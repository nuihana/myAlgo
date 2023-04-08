package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem11727 {
    int[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        dp = new int[num + 1];
        dp[1] = 1;
        if (num > 1) {
            dp[2] = 3;
        }

        bw.write(String.valueOf(memoization(num)));

        br.close();
        bw.close();
    }

    private int memoization(int num) {
        if (dp[num] > 0) {
            return dp[num];
        }

        return dp[num] = (memoization(num - 1) + memoization(num - 2) * 2) % 10007;
    }
}
