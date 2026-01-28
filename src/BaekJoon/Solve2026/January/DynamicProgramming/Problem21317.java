package BaekJoon.Solve2026.January.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem21317 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[21][2]; // 0 : +1, 1 : +2
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[21][2]; // 0 : use, 1 : not use
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 999999);
        }

        dp[1][0] = 0;
        dp[2][0] = cost[1][0];
        dp[3][0] = Math.min(cost[1][0] + cost[2][0], cost[1][1]);
        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(cost[i - 1][0] + dp[i - 1][0], cost[i - 2][1] + dp[i - 2][0]);
            dp[i][1] = Math.min(Math.min(cost[i - 1][0] + dp[i - 1][1], cost[i - 2][1] + dp[i - 2][1]), k + dp[i - 3][0]);
        }

        System.out.print(Math.min(dp[n][0], dp[n][1]));

        br.close();
    }
}
