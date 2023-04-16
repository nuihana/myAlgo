package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem1699 {
    Integer[] dp = new Integer[100001];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        dp[0] = 0;
        for (int i = 1; i * i <= 100000; i++) {
            dp[i * i] = 1;
        }
        bw.write(String.valueOf(memoization(num)));

        br.close();
        bw.close();
    }

    private int memoization(int num) {
        if (dp[num] == null) {
            dp[num] = 100000;
            for (int i = (int) Math.sqrt(num); i >= 0; i--) {
                int pow = (int) Math.pow(i, 2);
                dp[num] = Math.min(memoization(num - pow) + 1, dp[num]);
            }
        }
        return dp[num];
    }
}
