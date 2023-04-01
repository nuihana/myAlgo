package BaekJoon.Solve2023.March.DinamicPlanning2nd;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2629 {
    int chooCnt;
    int[] chooArr;
    boolean[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        chooCnt = Integer.parseInt(br.readLine());
        chooArr = new int[chooCnt + 1];
        dp = new boolean[chooCnt + 1][15001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < chooCnt; i++) {
            chooArr[i] = Integer.parseInt(st.nextToken());
        }

        int inputCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < inputCnt; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (input > 15000) {
                bw.write("N ");
            } else if (dp[chooCnt][input]) {
                bw.write("Y ");
            } else {
                bw.write("N ");
            }
        }

        br.close();
        bw.close();
    }

    private void dp(int idx, int num) {
        if (chooCnt < idx || dp[idx][num]) {
            return;
        }

        dp[idx][num] = true;
        dp(idx + 1, num); // 무게 추 안올림
        dp(idx + 1, num + chooArr[idx]); // 무게추 합
        dp(idx + 1, Math.abs(num - chooArr[idx])); // 무게추 차
    }
}
