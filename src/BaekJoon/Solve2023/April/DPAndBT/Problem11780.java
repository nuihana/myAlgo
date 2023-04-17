package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.*;

public class Problem11780 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cityCnt = Integer.parseInt(br.readLine());
        int busCnt = Integer.parseInt(br.readLine());
        int[][] moveCostArr = new int[cityCnt + 1][cityCnt + 1];
        List<Integer>[][] routeArr = new List[cityCnt + 1][cityCnt + 1];

        final int INF = 10000001;
        for (int i = 1; i <= cityCnt; i++) {
            Arrays.fill(moveCostArr[i], INF);
            moveCostArr[i][i] = 0;
        }

        StringTokenizer st;
        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (cost < moveCostArr[from][to]) {
                moveCostArr[from][to] = cost;

                if (routeArr[from][to] == null) {
                    List<Integer> tmpList = new ArrayList<>();

                    tmpList.add(from);
                    tmpList.add(to);

                    routeArr[from][to] = tmpList;
                } else {
                    routeArr[from][to].clear();

                    routeArr[from][to].add(from);
                    routeArr[from][to].add(to);
                }
            }
        }

        // floid-warshal
        for (int k = 1; k <= cityCnt; k++) {
            for (int i = 1; i <= cityCnt; i++) {
                for (int j = 1; j <= cityCnt; j++) {
                    if (moveCostArr[i][k] + moveCostArr[k][j] < moveCostArr[i][j]) {
                        moveCostArr[i][j] = moveCostArr[i][k] + moveCostArr[k][j];

                        if (routeArr[i][j] == null) {
                            List<Integer> tmpList = new ArrayList<>(routeArr[i][k]);

                            tmpList.remove(tmpList.size() - 1); // i ~ k, k ~ j 입력시 k가 겹침
                            tmpList.addAll(routeArr[k][j]);

                            routeArr[i][j] = tmpList;
                        } else {
                            routeArr[i][j].clear();

                            routeArr[i][j].addAll(routeArr[i][k]);
                            routeArr[i][j].remove(routeArr[i][j].size() - 1);
                            routeArr[i][j].addAll(routeArr[k][j]);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= cityCnt; i++) {
            for (int j = 1; j <= cityCnt; j++) {
                if (moveCostArr[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(moveCostArr[i][j] + " ");
                }
            }
            bw.newLine();
        }

        StringBuilder sb;
        for (int i = 1; i <= cityCnt; i++) {
            for (int j = 1; j <= cityCnt; j++) {
                sb = new StringBuilder();
                if(routeArr[i][j] == null) {
                    sb.append("0");
                } else {
                    sb.append(routeArr[i][j].size() + " ");
                    for (int k = 0; k < routeArr[i][j].size(); k++) {
                        sb.append(routeArr[i][j].get(k) + " ");
                    }
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
