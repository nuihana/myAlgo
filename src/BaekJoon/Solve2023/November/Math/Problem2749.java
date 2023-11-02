package BaekJoon.Solve2023.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2749 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pisano = 1500000;
        long num = Long.parseLong(br.readLine()) % pisano;;

        long[] dp = new long[pisano + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= pisano; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
        }

        System.out.print(dp[(int) num]);

        br.close();
    }
}
