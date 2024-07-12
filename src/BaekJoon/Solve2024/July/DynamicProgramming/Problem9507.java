package BaekJoon.Solve2024.July.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9507 {
    long[] dp = new long[68];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int query = Integer.parseInt(br.readLine());
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();
        while (query-- > 0) {
            int q = Integer.parseInt(br.readLine());
            sb.append(memoization(q)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private long memoization(int id) {
        if (dp[id] > 0) return dp[id];

        return dp[id] = memoization(id - 1) + memoization(id - 2) + memoization(id - 3) + memoization(id - 4);
    }
}
