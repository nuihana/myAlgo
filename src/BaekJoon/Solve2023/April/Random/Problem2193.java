package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem2193 {
    Long[][] dp = new Long[91][2];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        dp[1][0] = 1L;
        dp[1][1] = 0L;
        bw.write(String.valueOf(getIchin(num, 0)));

        br.close();
        bw.close();
    }

    private long getIchin(int num, int idx) {
        if (dp[num][idx] != null) {
            return dp[num][idx];
        }

        if (idx == 0) {
            return dp[num][0] = getIchin(num - 1, 0) + getIchin(num - 1, 1);
        } else {
            return dp[num][1] = getIchin(num - 1, 0);
        }
    }
}
