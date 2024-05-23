package BaekJoon.Solve2024.May.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13301 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[81];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        if (n == 1) System.out.print("4");
        else System.out.print(dp[n] * 2 + (dp[n] + dp[n - 1]) * 2);

        br.close();
    }
}
