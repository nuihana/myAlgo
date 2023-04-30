package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem1309 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] dp = new int[num][4];

        dp[0][0] = 3;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        for (int i = 1; i < num; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 9901;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 9901;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 9901;
            dp[i][0] = (dp[i][1] + dp[i][2] + dp[i][3]) % 9901;
        }

        bw.write(String.valueOf(dp[num - 1][0]));

        br.close();
        bw.close();
    }
}
