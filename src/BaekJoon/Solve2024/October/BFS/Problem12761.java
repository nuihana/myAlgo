package BaekJoon.Solve2024.October.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem12761 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] mem = new boolean[100001];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        pq.offer(new int[]{ n, 0 });
        mem[n] = true;
        int[] dx = { 1, -1, a, -a, b, -b };
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == m) {
                System.out.print(now[1]);
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                if (nx < 0 || nx > 100000 || mem[nx]) continue;
                mem[nx] = true;
                pq.offer(new int[]{ nx, now[1] + 1 });
            }

            int nx = now[0] * a;
            if (nx >= 0 && nx <= 100000 && !mem[nx]) {
                mem[nx] = true;
                pq.offer(new int[]{ nx, now[1] + 1 });
            }

            nx = now[0] * b;
            if (nx >= 0 && nx <= 100000 && !mem[nx]) {
                mem[nx] = true;
                pq.offer(new int[]{ nx, now[1] + 1 });
            }
        }

        br.close();
    }
}
