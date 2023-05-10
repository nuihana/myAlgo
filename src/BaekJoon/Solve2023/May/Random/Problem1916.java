package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem1916 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cityCnt = Integer.parseInt(br.readLine());
        int busCnt = Integer.parseInt(br.readLine());

        Map<Integer, List<Bus>> busMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < busCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (busMap.get(from) == null) {
                List<Bus> tmpList = new ArrayList<>();

                tmpList.add(new Bus(to, cost));

                busMap.put(from, tmpList);
            } else {
                busMap.get(from).add(new Bus(to, cost));
            }
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        final int INF = 100000000;
        PriorityQueue<Bus> que = new PriorityQueue<>((b1, b2) -> b1.cost - b2.cost);
        int[] cost = new int[cityCnt + 1];
        Arrays.fill(cost, INF);
        que.offer(new Bus(from, 0));
        while(!que.isEmpty()) {
            Bus tmp = que.poll();

            if (tmp.idx == to) {
                bw.write(String.valueOf(tmp.cost));
                break;
            }

            if (cost[tmp.idx] < tmp.cost) continue;

            cost[tmp.idx] = tmp.cost;

            if (busMap.get(tmp.idx) != null) {
                for (Bus b : busMap.get(tmp.idx)) {
                    if (cost[b.idx] > tmp.cost + b.cost) {
                        que.offer(new Bus(b.idx, tmp.cost + b.cost));
                    }
                }
            }
        }

        br.close();
        bw.close();
    }

    class Bus {
        int idx;
        int cost;

        public Bus(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
