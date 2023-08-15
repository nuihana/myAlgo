package BaekJoon.Solve2023.August.Conte_Arena2nd;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemC {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long max = Long.MIN_VALUE;
        PriorityQueue<Long> que = new PriorityQueue<>((l1, l2) -> Long.compare(l1, l2));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            que.offer(a);
            max = Math.max(max, a);
        }

        long initialMax = max;
        long dif = max - que.peek();
        while(true) {
            long now = que.poll();
            if (now == initialMax) break;

            now *= 2;
            max = Math.max(max, now);
            que.offer(now);

            dif = Math.min(dif, max - que.peek());
        }

        bw.write(String.valueOf(dif));

        br.close();
        bw.close();
    }
}
