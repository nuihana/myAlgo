package BaekJoon.Solve2024.June.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4811 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        long[][] dp = new long[31][31];
        dp[1][0] = 1L;
        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j <= 30; j++) {
                if (i < 30) dp[i + 1][j] += dp[i][j];
                if (j < i) dp[i][j + 1] += dp[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) > 0) {
            sb.append(dp[n][n]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
