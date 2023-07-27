package BaekJoon.Solve2023.July.Random;

import java.io.*;

public class Problem1562 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int VISIT = (1 << 10);
        long[][][] dp = new long[n + 1][10][VISIT];
        final int MOD = 1000000000;

        for (int i = 1; i < 10; i++) dp[1][i][(1 << i)] = 1;

        int bit;
        long res = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < VISIT; k++) {
                    bit = k | (1 << j);
                    dp[i][j][bit] += ((0 < j ? dp[i - 1][j - 1][k] : 0) +
                            (j < 9 ? dp[i - 1][j + 1][k] : 0)) % MOD;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            res += dp[n][i][VISIT - 1];
            res %= MOD;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
