package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem17626 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;

        for (int i = 2; i <= 50000; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int tmp = i - j * j;
                min = Math.min(min, dp[tmp]);
            }

            dp[i] = min + 1;
        }

        bw.write(String.valueOf(dp[num]));

        br.close();
        bw.close();
    }
}
