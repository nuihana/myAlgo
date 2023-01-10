package BaekJoon.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11053 {
    int[] valArr;
    Integer[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        valArr = new int[input];
        dp = new Integer[input];
        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; st.hasMoreTokens(); i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < input; i++) {
            getMaximumAsc(i);
        }

        int max = dp[0];
        for (int i = 1; i < input; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);

        br.close();
    }

    private int getMaximumAsc(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (valArr[i] < valArr[n]) {
                    dp[n] = Math.max(dp[n], getMaximumAsc(i) + 1);
                }
            }
        }

        return dp[n];
    }
}
