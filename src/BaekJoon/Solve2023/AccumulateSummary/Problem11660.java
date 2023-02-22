package BaekJoon.Solve2023.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11660 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                sumArr[i][j] += Integer.parseInt(st.nextToken());
                if (i > 0) {
                    sumArr[i][j] += sumArr[i - 1][j];
                }
                if (j > 0) {
                    sumArr[i][j] += sumArr[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sumArr[i][j] -= sumArr[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());

            int bf_x = Integer.parseInt(st.nextToken());
            int bf_y = Integer.parseInt(st.nextToken());

            int af_x = Integer.parseInt(st.nextToken());
            int af_y = Integer.parseInt(st.nextToken());

            int result = sumArr[af_x - 1][af_y - 1];

            if (bf_x > 1) {
                result -= sumArr[bf_x - 2][af_y - 1];
            }
            if (bf_y > 1) {
                result -= sumArr[af_x - 1][bf_y - 2];
            }
            if (bf_x > 1 && bf_y > 1) {
                result += sumArr[bf_x - 2][bf_y - 2];
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
