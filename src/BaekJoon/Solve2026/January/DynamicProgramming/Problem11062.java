package BaekJoon.Solve2026.January.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11062 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n + 1][n + 1];
            solve(0, n - 1, true, dp, arr);
            sb.append(dp[0][n - 1]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int solve(int left, int right, boolean flag, int[][] dp, int[] arr) {
        if (left > right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        if (flag) {
            return dp[left][right] = Math.max(arr[left] + solve(left + 1, right, false, dp, arr), arr[right] + solve(left, right - 1, false, dp, arr));
        } else {
            return dp[left][right] = Math.min(solve(left + 1, right, true, dp, arr), solve(left, right - 1, true, dp, arr));
        }
    }
}
