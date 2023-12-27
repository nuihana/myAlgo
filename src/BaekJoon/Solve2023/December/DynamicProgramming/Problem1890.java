package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1890 {
    int n;
    int[][] arr;
    Long[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(memoization(0, 0));

        br.close();
    }

    private long memoization(int x, int y) {
        if (x >= n || y >= n) return 0;
        if (x == n - 1 && y == n - 1) return 1;
        if (arr[x][y] == 0) return dp[x][y] = 0L;
        if (dp[x][y] != null) return dp[x][y];

        return dp[x][y] = memoization(x + arr[x][y], y) + memoization(x, y + arr[x][y]);
    }
}
