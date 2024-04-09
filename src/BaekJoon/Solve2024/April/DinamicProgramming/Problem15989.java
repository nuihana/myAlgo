package BaekJoon.Solve2024.April.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15989 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        int[] arr = new int[numCnt];

        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCnt; i++) {
            sb.append(dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
