package BaekJoon.Solve2023.DinamicPlanning2nd;

import java.io.*;
import java.util.*;

public class Problem2293 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCnt = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coinArr = new int[coinCnt + 1];
        int[][] dp = new int[coinCnt + 1][target + 1];

        for (int i = 1; i <= coinCnt; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coinCnt; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coinArr);

        for (int val = 1; val <= target; val++) {
            for (int each = 1; each <= coinCnt; each++) {
                dp[each][val] = ( val - coinArr[each] < 0 ? 0 : dp[each][val - coinArr[each]] ) + dp[each - 1][val];
            }
        }

        bw.write(Integer.toString(dp[coinCnt][target]));

        br.close();
        bw.close();
    }
}
