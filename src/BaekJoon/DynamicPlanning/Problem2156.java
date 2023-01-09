package BaekJoon.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2156 {
    int[] amount;
    Integer[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        amount = new int[input + 1];
        dp = new Integer[input + 1];

        for (int i = 1; i <= input; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = amount[0];
        dp[1] = amount[1];

        if (input >= 2) {
            dp[2] = amount[1] + amount[2];
        }

        if (input > 2) {
            dp[3] = Math.max(dp[2], Math.max(amount[1] + amount[3], amount[2] + amount[3]));
        }

        System.out.print(getMinimum(input));

        br.close();
    }

    private int getMinimum(int n) {
        if (dp[n] == null) {
            return dp[n] = Math.max(Math.max(amount[n - 1] + getMinimum(n - 3), getMinimum(n - 2)) + amount[n], amount[n - 1] + amount[n - 2] + getMinimum(n - 4));
        }

        return dp[n];
    }
}
