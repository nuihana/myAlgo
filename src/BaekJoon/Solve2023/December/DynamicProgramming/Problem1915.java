package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1915 {
    int n, m;
    int[][] sqr, dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sqr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                sqr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.print(memoization());

        br.close();
    }

    private int memoization() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = sqr[i][j];
                if (i != 0 && j != 0 && dp[i][j] != 0) {
                    int up = dp[i][j - 1];
                    int left = dp[i - 1][j];
                    int ul = dp[i - 1][j - 1];

                    int minVal = Math.min(Math.min(up, left), ul);
                    dp[i][j] = minVal + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
