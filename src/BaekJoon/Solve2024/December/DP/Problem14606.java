package BaekJoon.Solve2024.December.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14606 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        System.out.print(memoization(n, dp));

        br.close();
    }

    private int memoization(int n, Integer[] dp) {
        if (dp[n] != null) return dp[n];

        int a = n / 2;
        int b = n - a;

        return dp[n] = memoization(a, dp) + memoization(b, dp);
    }
}
