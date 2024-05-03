package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13335 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int truckCnt = Integer.parseInt(st.nextToken());
        int bridgeLen = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < truckCnt; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int res = 0;
        Queue<int[]> bridge = new LinkedList<>();
        while (true) {
            int nowSize = bridge.size();
            int nowWeight = 0;
            while (nowSize-- > 0) {
                int[] truck = bridge.poll();

                truck[1]++;
                if (truck[1] >= bridgeLen) continue;

                nowWeight += truck[0];
                bridge.offer(truck);
            }

            if (!q.isEmpty()) {
                int next = q.peek();

                if (nowWeight + next <= maxWeight) {
                    bridge.add(new int[]{ q.poll(), 0 });
                }
            }

            res++;

            if (q.isEmpty() && bridge.isEmpty()) break;
        }

        System.out.print(res);

        br.close();
    }
}
