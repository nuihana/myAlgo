package BaekJoon.Solve2025.November.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem12849 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][8];
        dp[0][0] = 1;
        final int MOD = 1000000007;

        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = (dp[i][1] + dp[i][2]) % MOD;
            dp[i + 1][1] = (dp[i][0] + dp[i][2] + dp[i][3]) % MOD;
            dp[i + 1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][5]) % MOD;
            dp[i + 1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % MOD;
            dp[i + 1][4] = (dp[i][3] + dp[i][5] + dp[i][6]) % MOD;
            dp[i + 1][5] = (dp[i][2] + dp[i][3] + dp[i][4] + dp[i][7]) % MOD;
            dp[i + 1][6] = (dp[i][4] + dp[i][7]) % MOD;
            dp[i + 1][7] = (dp[i][5] + dp[i][6]) % MOD;
        }

        System.out.print(dp[n][0]);

        br.close();
    }
}
