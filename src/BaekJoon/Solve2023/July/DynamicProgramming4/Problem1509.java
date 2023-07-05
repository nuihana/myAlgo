package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.*;

public class Problem1509 {
    int[] dp;
    boolean[][] isPalindrome;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        dp = new int[input.length() + 1];
        isPalindrome = new boolean[input.length() + 1][input.length() + 1];

        for (int i = 1; i <= input.length(); i++) {
            for (int j = i; j <= input.length(); j++) {
                boolean flag = true;
                int s = i - 1;
                int e = j - 1;
                while (s <= e) {
                    if (input.charAt(s++) != input.charAt(e--)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        Arrays.fill(dp, 2501);
        dp[0] = 0;
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        bw.write(String.valueOf(dp[input.length()]));

        br.close();
        bw.close();
    }
}
