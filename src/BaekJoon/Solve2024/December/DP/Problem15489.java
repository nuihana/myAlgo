package BaekJoon.Solve2024.December.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15489 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        dp[1][1] = 1;

        int res = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < i + 1; j++) {
                res += memoization(dp, r + i, c + j);
            }
        }
        System.out.print(res);

        br.close();
    }

    private int memoization(int[][] dp, int r, int c) {
        if (c == 0 || r < c) return 0;
        if (dp[r][c] > 0) return dp[r][c];
        return dp[r][c] = memoization(dp, r - 1, c - 1) + memoization(dp, r - 1, c);
    }
}
