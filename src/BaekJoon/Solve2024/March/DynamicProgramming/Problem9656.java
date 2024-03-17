package BaekJoon.Solve2024.March.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9656 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stoneCnt = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4;  i <= stoneCnt; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        if (dp[stoneCnt] % 2 == 0) {
            System.out.print("SK");
        } else {
            System.out.print("CY");
        }

        br.close();
    }
}
