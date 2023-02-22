package BaekJoon.Solve2023.DinamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1463 {
    private Integer[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        dp = new Integer[input + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(input));

        br.close();
    }

    private int recur(int value) {
        if (dp[value] == null) {
            if (value % 6 == 0) {
                dp[value] = Math.min(recur(value - 1), Math.min(recur(value / 3), recur(value / 2))) + 1;
            } else if (value % 3 == 0) {
                dp[value] = Math.min(recur(value / 3), recur(value - 1)) + 1;
            } else if (value % 2 == 0) {
                dp[value] = Math.min(recur(value / 2), recur(value - 1)) + 1;
            } else {
                dp[value] = recur(value - 1) + 1;
            }
        }
        return dp[value];
    }
}
