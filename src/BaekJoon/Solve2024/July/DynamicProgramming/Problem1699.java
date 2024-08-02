package BaekJoon.Solve2024.July.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1699 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[0] = 1L;

        System.out.print(memoization(n, dp));

        br.close();
    }

    private long memoization(int idx, long[] dp) {
        if (dp[idx] > 0) return dp[idx];

        for (int i = 0; i < idx; i++) {
            dp[idx] = memoization(i, dp) * memoization(idx - i, dp);
        }
        return dp[idx];
    }
}
