package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2225 {
    int[][] dp = new int[201][201];
    private final int MOD = 1000000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(memoization(n, k)));

        br.close();
        bw.close();
    }

    private int memoization(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == 1) {
            return dp[n][k] = k;
        }

        if (k == 1) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (memoization(n - 1, k) + memoization(n, k - 1)) % MOD;
    }
}
