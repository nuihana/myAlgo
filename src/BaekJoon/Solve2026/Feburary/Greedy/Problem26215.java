package BaekJoon.Solve2026.Feburary.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem26215 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int res = 0;
        while (!pq.isEmpty() && res <= 1440) {
            if (pq.size() == 1) {
                if (pq.peek() > 1) pq.offer(pq.poll() - 1);
                else pq.poll();
            } else {
                int peek = pq.poll();
                int next = pq.poll();

                if (peek > 1) pq.offer(peek - 1);
                if (next > 1) pq.offer(next - 1);
            }
            res++;
        }

        System.out.print(res > 1440 ? -1 : res);

        br.close();
    }
}
