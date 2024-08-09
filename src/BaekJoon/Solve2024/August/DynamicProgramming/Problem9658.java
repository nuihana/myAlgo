package BaekJoon.Solve2024.August.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9658 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 2;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            dp[i] = 2;
            if (dp[i - 1] == 2 || dp[i - 3] == 2 || dp[i - 4] == 2) dp[i] = 1;
        }

        if (dp[n] == 1) {
            System.out.print("SK");
        } else {
            System.out.print("CY");
        }

        br.close();
    }
}
