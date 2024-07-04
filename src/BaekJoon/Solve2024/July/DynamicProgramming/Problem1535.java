package BaekJoon.Solve2024.July.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1535 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[n + 1][100];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[n][99]);

        br.close();
    }
}
