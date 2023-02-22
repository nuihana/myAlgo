package BaekJoon.Solve2023.DinamicPlanning;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1932 {
    int[][] valArr;
    Integer[][] resArr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCnt = Integer.parseInt(br.readLine());
        valArr = new int[inputCnt][inputCnt];
        resArr = new Integer[inputCnt][inputCnt];

        for(int i = 0; i < inputCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
                valArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < inputCnt; i++) {
            resArr[inputCnt - 1][i] = valArr[inputCnt - 1][i];
        }

        bw.write(Integer.toString(getResult(0, 0, inputCnt)));

        br.close();
        bw.close();
    }

    private int getResult(int depth, int idx, int size) {
        if (depth == size - 1) {
            return resArr[depth][idx];
        }

        if (resArr[depth][idx] == null) {
            resArr[depth][idx] = Math.max(getResult(depth + 1, idx, size), getResult(depth + 1, idx + 1, size)) + valArr[depth][idx];
        }

        return resArr[depth][idx];
    }
}
