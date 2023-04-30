package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.Arrays;

public class Problem11057 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[][] dp = new int[num][11];
        Arrays.fill(dp[0], 1);
        dp[0][0] = 10;

        for (int i = 1; i < num; i++) {
            for (int j = 1; j < 11; j++) {
                for (int k = j; k < 11; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }

            for (int j = 1; j < 11; j++) {
                dp[i][0] += dp[i][j];
                dp[i][0] %= 10007;
            }
        }

        bw.write(String.valueOf(dp[num - 1][0]));

        br.close();
        bw.close();
    }
}
