package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1937 {
    int n;
    int[][] amount;
    int[][] dp;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        amount = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                amount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }

        System.out.print(res);

        br.close();
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int[] next = { i + dx[k], j + dy[k] };
            if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) continue;
            if (amount[next[0]][next[1]] > amount[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dfs(next[0], next[1]) + 1);
            }
        }

        return dp[i][j];
    }
}
