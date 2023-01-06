package BaekJoon.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10844 {
    long result = 0;
    Long[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        dp = new Long[input + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 1; i < 10; i++) {
            result += dfs(input, i);
        }

        System.out.print(result % 1000000000);

        br.close();
    }

    private long dfs(int digit, int value) {
        if (digit == 1) {
            return dp[digit][value];
        }

        if (dp[digit][value] == null) {
            if (value == 0) {
                dp[digit][value] = dfs(digit - 1, 1);
            } else if (value == 9) {
                dp[digit][value] = dfs(digit - 1, 8);
            } else {
                dp[digit][value] = dfs(digit - 1, value - 1) + dfs(digit - 1, value + 1);
            }
        }
        return dp[digit][value] % 1000000000;
    }
}
