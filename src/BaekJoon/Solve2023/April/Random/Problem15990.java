package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem15990 {
    Integer[][] dp = new Integer[100001][4];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][0] = 1;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][0] = 3;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 0; i < caseCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(getCaseCnt(num, 0)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int getCaseCnt(int num, int idx) {
        if (dp[num][idx] != null) {
            return dp[num][idx];
        }

        if (idx == 0) {
            return dp[num][0] = getCaseCnt(num, 1) + getCaseCnt(num, 2) + getCaseCnt(num, 3);
        } else if (idx == 1){
            return dp[num][1] = getCaseCnt(num - 1, 2) + getCaseCnt(num - 1, 3);
        } else if (idx == 2){
            return dp[num][2] = getCaseCnt(num - 2, 1) + getCaseCnt(num - 2, 3);
        } else if (idx == 3){
            return dp[num][3] = getCaseCnt(num - 3, 1) + getCaseCnt(num - 3, 2);
        }

        return dp[num][idx];
    }
}
