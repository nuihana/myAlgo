package BaekJoon.Solve2024.October.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14494 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][m + 1];
        final int MOD = 1000000007;
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= m; j++) {
                dp[i][j] = ((dp[i - 1][j] + dp[i][j - 1]) % MOD + dp[i - 1][j - 1]) % MOD;
            }
        }

        System.out.print(dp[n][m]);

        br.close();
    }
}
