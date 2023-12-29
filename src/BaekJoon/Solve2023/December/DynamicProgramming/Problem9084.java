package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9084 {
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

            int pur = Integer.parseInt(br.readLine());
            int[] dp = new int[pur + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= pur; j++) {
                    if (j - arr[i] > 0) {
                        dp[j] = dp[j] + dp[j - arr[i]];
                    } else if (j - arr[i] == 0) {
                        dp[j]++;
                    }
                }
            }

            sb.append(dp[pur]).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
