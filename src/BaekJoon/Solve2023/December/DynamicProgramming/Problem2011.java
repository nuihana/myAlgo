package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2011 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int[] dp = new int[src.length() + 1];
        int[] arr = new int[src.length() + 1];
        for (int i = 0; i < src.length(); i++) {
            arr[i + 1] = src.charAt(i) - '0';
        }

        dp[0] = 1;

        for (int i = 1; i <= src.length(); i++) {
            if (arr[i] != 0) dp[i] = (dp[i - 1] + dp[i]) % 1000000;
            int chk = arr[i] + arr[i - 1] * 10;
            if (10 <= chk && chk <= 26) dp[i] = (dp[i - 2] + dp[i]) % 1000000;
        }

        System.out.println(dp[src.length()] % 1000000);

        br.close();
    }
}
