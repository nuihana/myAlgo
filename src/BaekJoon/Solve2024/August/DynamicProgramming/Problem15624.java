package BaekJoon.Solve2024.August.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15624 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] dp = new Integer[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        System.out.print(memoization(dp, n));

        br.close();
    }

    private int memoization(Integer[] dp, int idx) {
        if (dp[idx] != null) return dp[idx];
        return dp[idx] = (memoization(dp, idx - 1) + memoization(dp, idx - 2)) % 1000000007;
    }
}
