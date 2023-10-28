package BaekJoon.Solve2023.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem19598 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            que.offer(new int[]{ from, 0, i });
            que.offer(new int[]{ to, 1, i });
        }

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();
            if (now[1] == 0) {
                set.add(now[2]);
            } else {
                set.remove(now[2]);
            }
            ans = Math.max(ans, set.size());
        }

        System.out.print(ans);

        br.close();
    }
}
