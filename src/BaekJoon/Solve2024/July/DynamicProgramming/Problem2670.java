package BaekJoon.Solve2024.July.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2670 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double[] dp = new double[n];
        double max = 0D;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            for (int j = i; j > 0; j--) {
                dp[j] = arr[i] * dp[j - 1];
                max = Math.max(max, dp[j]);
            }
            dp[0] = arr[i];
        }

        System.out.printf("%.3f", max);

        br.close();
    }
}
