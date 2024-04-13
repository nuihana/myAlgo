package BaekJoon.Solve2024.April.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem10826 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("0");
        if (n > 0) {
            dp[1] = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2]);
            }
        }

        System.out.print(dp[n].toString());

        br.close();
    }
}
