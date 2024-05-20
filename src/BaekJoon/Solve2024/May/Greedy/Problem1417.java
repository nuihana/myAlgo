package BaekJoon.Solve2024.May.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem1417 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int candidateCnt = Integer.parseInt(br.readLine());
        int picked = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < candidateCnt - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int res = 0;
        while (true) {
            int top = pq.poll();
            if (picked > top) break;

            picked++;
            pq.offer(--top);
            res++;
        }

        System.out.print(res);

        br.close();
    }
}
