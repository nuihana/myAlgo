package BaekJoon.Solve2023.March.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem25682 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int lineCnt = Integer.parseInt(st.nextToken());
        int colCnt = Integer.parseInt(st.nextToken());
        int ansSize = Integer.parseInt(st.nextToken());
        char[] caseArr = {'B', 'W'};

        int[][] ps_w = new int[lineCnt][colCnt];
        int[][] ps_b = new int[lineCnt][colCnt];

        for (int i = 0; i < lineCnt; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < colCnt; j++) {
                if (tmp.charAt(j) == caseArr[(j + i) % 2]) {
                    ps_b[i][j]++;
                } else {
                    ps_w[i][j]++;
                }

                if (i > 0) {
                    ps_b[i][j] += ps_b[i - 1][j];
                    ps_w[i][j] += ps_w[i - 1][j];
                }
                if (j > 0) {
                    ps_b[i][j] += ps_b[i][j - 1];
                    ps_w[i][j] += ps_w[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    ps_b[i][j] -= ps_b[i - 1][j - 1];
                    ps_w[i][j] -= ps_w[i - 1][j - 1];
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0, iLimit = lineCnt - ansSize + 1; i < iLimit; i++) {
            for (int j = 0, jLimit = colCnt - ansSize + 1; j < jLimit; j++) {
                int val_b = ps_b[ansSize - 1 + i][ansSize - 1 + j];
                int val_w = ps_w[ansSize - 1 + i][ansSize - 1 + j];
                if (i > 0) {
                    val_b -= ps_b[i - 1][ansSize - 1 + j];
                    val_w -= ps_w[i - 1][ansSize - 1 + j];
                }
                if (j > 0) {
                    val_b -= ps_b[ansSize - 1 + i][j - 1];
                    val_w -= ps_w[ansSize - 1 + i][j - 1];
                }
                if (i > 0 && j > 0) {
                    val_b += ps_b[i - 1][j - 1];
                    val_w += ps_w[i - 1][j - 1];
                }

                result = Math.min(result, Math.min(val_w, val_b));
            }
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }
}
