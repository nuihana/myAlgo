package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2631 {
    int[] arr, dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n];
        int lis = 0;
        for (int i = 0; i < n; i++) {
            lis = Math.max(lis, memoization(i));
        }

        System.out.print(n - lis);

        br.close();
    }

    private int memoization(int idx) {
        if (dp[idx] > 0) return dp[idx];

        int res = 1;
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                res = Math.max(res, 1 + memoization(i));
            }
        }

        return dp[idx] = res;
    }
}
