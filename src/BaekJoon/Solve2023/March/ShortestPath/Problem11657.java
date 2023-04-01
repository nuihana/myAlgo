package BaekJoon.Solve2023.March.ShortestPath;

import java.io.*;
import java.util.*;

public class Problem11657 {
    List<Bus> busList;
    final int inf = 5000000;
    long[] costArr;
    int cityCnt;
    int lineCnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cityCnt = Integer.parseInt(st.nextToken());
        lineCnt = Integer.parseInt(st.nextToken());

        busList = new ArrayList<>();
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busList.add(new Bus(from, to, cost));
        }

        StringBuilder sb = new StringBuilder();
        costArr = new long[cityCnt + 1];

        boolean isNegativeCycle = bellmanFord(1);

        if (isNegativeCycle) {
            bw.write("-1");
        } else {
            for (int i = 2; i <= cityCnt; i++) {
                if (costArr[i] == inf) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(costArr[i]));
                }
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private boolean bellmanFord(int start) {
        Arrays.fill(costArr, inf);
        costArr[start] = 0;

        for (int i = 0; i < cityCnt; i++) {
            for (int j = 0; j < lineCnt; j++) {
                int from = busList.get(j).from;
                int to = busList.get(j).to;
                int cost = busList.get(j).cost;

                if (costArr[from] != inf && costArr[to] > costArr[from] + cost) {
                    costArr[to] = costArr[from] + cost;
                    if (i == cityCnt - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    class Bus {
        int from;
        int to;
        int cost;
        public Bus(int from_, int to_, int cost_) {
            this.from = from_;
            this.to = to_;
            this.cost = cost_;
        }
    }
}
