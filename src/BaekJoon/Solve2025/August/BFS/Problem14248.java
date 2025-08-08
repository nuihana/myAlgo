package BaekJoon.Solve2025.August.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14248 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        int start = Integer.parseInt(br.readLine());
        q.offer(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            int nx = nums[now];
            if (now + nx <= n && !visit[now + nx]) {
                visit[now + nx] = true;
                q.offer(now + nx);
            }

            if (now - nx >= 1 && !visit[now - nx]) {
                visit[now - nx] = true;
                q.offer(now - nx);
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i]) res++;
        }
        System.out.print(res);

        br.close();
    }
}
