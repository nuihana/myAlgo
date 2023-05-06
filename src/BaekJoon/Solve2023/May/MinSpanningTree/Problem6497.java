package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem6497 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int homeCnt = Integer.parseInt(st.nextToken());
            int roadCnt = Integer.parseInt(st.nextToken());

            if (homeCnt == 0 && roadCnt == 0) {
                break;
            }

            List<Road> roadList = new ArrayList<>();
            for (int i = 0; i < roadCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                roadList.add(new Road(from, to, cost));
            }

            Collections.sort(roadList);

            uf = new int[homeCnt];
            for (int i = 1; i < homeCnt; i++) {
                uf[i] = i;
            }

            int result = 0;
            for (Road r : roadList) {
                if (find(r.from) != find(r.to)) {
                    union(r.from, r.to);
                } else {
                    result += r.cost;
                }
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int find(int num) {
        while(uf[num] != num) {
            num = uf[num];
        }
        return num;
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            uf[root_b] = root_a;
        }
    }

    class Road implements Comparable{
        int from;
        int to;
        int cost;

        public Road(int from_, int to_, int cost_) {
            this.from = from_;
            this.to = to_;
            this.cost = cost_;
        }

        @Override
        public int compareTo(Object o) {
            Road cpr = (Road) o;
            return this.cost - cpr.cost;
        }
    }
}
