package BaekJoon.Solve2024.July.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16395 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        System.out.print(memoization(dp, n - 1, k - 1));

        br.close();
    }

    private int memoization(int[][] dp, int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (r == 0 || c == r) return dp[r][c] = 1;
        if (dp[r][c] > 0) return dp[r][c];
        return dp[r][c] = memoization(dp, r - 1, c - 1) + memoization(dp, r - 1, c);
    }
}
