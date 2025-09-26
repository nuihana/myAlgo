package BaekJoon.Solve2025.September.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17212 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[100001];
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        dp[7] = 1;
        System.out.print(search(n, dp));

        br.close();
    }

    private int search(int val, int[] dp) {
        if (val == 0) return 0;
        if (dp[val] != 0) return dp[val];

        int res = Integer.MAX_VALUE;
        if (val >= 7) res = Math.min(res, search(val - 7, dp) + 1);
        if (val >= 5) res = Math.min(res, search(val - 5, dp) + 1);
        if (val >= 2) res = Math.min(res, search(val - 2, dp) + 1);

        return dp[val] = Math.min(search(val - 1, dp) + 1, res);
    }
}
