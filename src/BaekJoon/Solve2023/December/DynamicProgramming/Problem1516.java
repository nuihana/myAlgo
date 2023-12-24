package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1516 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] parent = new List[n + 1];
        List<Integer>[] child = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
        }
        int[] time = new int[n + 1];
        int[] sort = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int build = Integer.parseInt(st.nextToken());
                if (build == -1) break;
                child[build].add(i);
                parent[i].add(build);
                sort[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            if (sort[i] == 0) que.offer(i);
        }

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : child[now]) {
                sort[next]--;
                if (sort[next] == 0) que.offer(next);
            }

            for (int before : parent[now]) {
                dp[now] = Math.max(dp[now], dp[before]);
            }

            dp[now] += time[now];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
