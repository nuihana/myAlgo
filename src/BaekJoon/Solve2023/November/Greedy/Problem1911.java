package BaekJoon.Solve2023.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1911 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            return a1[1] - a2[1];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pq.add(new int[]{from, to});
        }

        int res = 0;
        int covered = -1;
        while (!pq.isEmpty()) {
            int[] pool = pq.poll();

            if (covered > pool[0]) pool[0] = covered;

            int until = pool[0];
            while (until < pool[1]) {
                res++;
                until += l;
            }

            covered = until;
        }
        System.out.println(res);

        br.close();
    }
}
