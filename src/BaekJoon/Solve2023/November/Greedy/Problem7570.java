package BaekJoon.Solve2023.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem7570 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lis = 0;
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken());
            lis = Math.max(lis, dp[idx] = dp[idx - 1] + 1);
        }

        System.out.print(n - lis);

        br.close();
    }
}
