package BaekJoon.Solve2023.May.Random;

import java.io.*;

public class Problem2748 {
    long[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;

        bw.write(String.valueOf(fibonacci(num)));

        br.close();
        bw.close();
    }

    private long fibonacci(int num) {
        if (dp[num] > 0) {
            return dp[num];
        }

        return dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
    }
}
