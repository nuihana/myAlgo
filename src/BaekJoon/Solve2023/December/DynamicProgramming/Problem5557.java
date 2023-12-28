package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5557 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n][21];
        dp[0][arr[0]]++;
        for (int i = 1; i < n; i++) {
            int now = arr[i];
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0) continue;

                if (j + now <= 20) dp[i][j + now] += dp[i - 1][j];
                if (j - now >= 0) dp[i][j - now] += dp[i - 1][j];
            }
        }

        System.out.print(dp[n - 2][arr[n - 1]]);

        br.close();
    }
}
