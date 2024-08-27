package BaekJoon.Solve2024.August.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1793 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for (int i = 3; i <= 250; i++) {
            dp[i] = dp[i - 2].multiply(BigInteger.TWO).add(dp[i - 1]);
        }
        while (true) {
            String src = br.readLine();
            if (src == null || src.isEmpty()) break;

            int n = Integer.parseInt(src);
            System.out.println(dp[n].toString());
        }

        br.close();
    }
}
