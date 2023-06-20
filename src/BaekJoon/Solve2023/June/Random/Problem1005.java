package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.*;

public class Problem1005 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int buildCnt = Integer.parseInt(st.nextToken());
            int orderCnt = Integer.parseInt(st.nextToken());

            int[] time = new int[buildCnt + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= buildCnt; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[buildCnt + 1];
            for (int j = 1; j <= buildCnt; j++) {
                graph[j] = new ArrayList<>();
            }

            int[] order = new int[buildCnt + 1];
            for (int j = 0; j < orderCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                order[b]++;
            }

            int end = Integer.parseInt(br.readLine());
            PriorityQueue<Build> que = new PriorityQueue<>((b1, b2) -> b1.time - b2.time);
            for(int j = 1; j <= buildCnt; j++) {
                if (order[j] == 0) que.offer(new Build(j, time[j]));
            }
            while (!que.isEmpty()) {
                Build now = que.poll();

                if (now.idx == end) {
                    bw.write(String.valueOf(now.time));
                    bw.newLine();
                    break;
                }

                for (int next : graph[now.idx]) {
                    order[next]--;
                    if(order[next] == 0) {
                        que.offer(new Build(next, now.time + time[next]));
                    }
                }
            }
        }

        br.close();
        bw.close();
    }

    class Build {
        int idx;
        int time;

        public Build(int idx_, int time_) {
            this.idx = idx_;
            this.time = time_;
        }
    }
}
