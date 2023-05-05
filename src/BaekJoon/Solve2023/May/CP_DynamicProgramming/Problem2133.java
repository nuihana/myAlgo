package BaekJoon.Solve2023.May.CP_DynamicProgramming;

import java.io.*;

public class Problem2133 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        long[] dp = new long[num + 1];

        dp[0] = 1;
        if (num > 1) {
            dp[2] = 3;
        }

        for (int i = 4; i <= num; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
        }

        bw.write(String.valueOf(dp[num]));

        br.close();
        bw.close();
    }
}
