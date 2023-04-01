package BaekJoon.Solve2023.March.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem1956 {
    final int inf = 4000000;
    int[][] pathCostMap;
    int cityCnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cityCnt = Integer.parseInt(st.nextToken());
        int pathCnt = Integer.parseInt(st.nextToken());

        pathCostMap = new int[cityCnt + 1][cityCnt + 1];
        for (int i = 0; i <= cityCnt; i++) {
            for (int j = 0; j <= cityCnt; j++) {
                if (i == j) {
                    pathCostMap[i][j] = 0;
                } else {
                    pathCostMap[i][j] = inf;
                }
            }
        }

        for (int i = 0 ; i < pathCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pathCostMap[from][to] = cost;
        }

        floydWarshall();

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= cityCnt; i++) {
            for (int j = i + 1; j <= cityCnt; j++) {
                result = Math.min(result, pathCostMap[i][j] + pathCostMap[j][i]);
            }
        }

        if (result > inf) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(result));
        }

        br.close();
        bw.close();
    }

    private void floydWarshall() {
        for (int i = 1; i <= cityCnt; i++) {
            for (int j = 1; j <= cityCnt; j++) {
                for (int k = 1; k <= cityCnt; k++) {
                    pathCostMap[j][k] = Math.min(pathCostMap[j][k], pathCostMap[j][i] + pathCostMap[i][k]);
                }
            }
        }
    }

    class Path {
        int idx;
        int cost;
        public Path(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
