package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem1238 {
    int vilageCnt;
    Map<Integer, List<Road>> roadMap;
    int[][] dp;
    final int MAXIMUM = 100000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        vilageCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());
        int partyIdx = Integer.parseInt(st.nextToken());

        roadMap = new HashMap<>();
        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if (roadMap.get(from) == null) {
                List<Road> tmpList = new ArrayList<>();

                tmpList.add(new Road(to, time));

                roadMap.put(from, tmpList);
            } else {
                roadMap.get(from).add(new Road(to, time));
            }
        }

        dp = new int[vilageCnt + 1][vilageCnt + 1];
        int result = 0;
        for (int i = 1; i <= vilageCnt; i++) {
            daijkstra(i, partyIdx);
            daijkstra(partyIdx, i);
            result = Math.max(result, dp[i][partyIdx] + dp[partyIdx][i]);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int daijkstra(int from, int to) {
        if (dp[from][to] > 0) return dp[from][to];

        int[] vilArr = new int[vilageCnt + 1];
        Arrays.fill(vilArr, MAXIMUM);
        vilArr[from] = 0;

        PriorityQueue<Road> que = new PriorityQueue<>((r1, r2) -> r1.time - r2.time);
        que.offer(new Road(from, 0));
        while(!que.isEmpty()) {
            Road r = que.poll();

            if (r.idx == to) {
                break;
            }

            if (roadMap.get(r.idx) != null) {
                for (Road next : roadMap.get(r.idx)) {
                    if (vilArr[next.idx] > r.time + next.time) {
                        vilArr[next.idx] = r.time + next.time;
                        que.offer(new Road(next.idx, r.time + next.time));
                    }
                }
            }
        }

        return dp[from][to] = vilArr[to];
    }

    class Road {
        int idx;
        int time;

        public Road(int idx_, int time_) {
            this.idx = idx_;
            this.time = time_;
        }
    }
}
