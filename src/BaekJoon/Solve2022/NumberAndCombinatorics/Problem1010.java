package BaekJoon.Solve2022.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1010 {
    int[][] caseArrs = new int[30][30];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write(Integer.toString(getCombinationNum(n, r)));
        }

        bw.close();
        br.close();
    }

    private int getCombinationNum(int n, int r) {
        if (caseArrs[n][r] > 0) {
            return caseArrs[n][r];
        }

        if (n == r || r == 0) {
            return caseArrs[n][r] = 1;
        }

        return caseArrs[n][r] = getCombinationNum(n - 1, r -1) + getCombinationNum(n - 1, r);
    }
}
