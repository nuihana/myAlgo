package BaekJoon.Solve2023.June.CP_BruteForce_Recursive;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15658 {
    int numCnt;
    int[] numArr;
    int[] operatorCnt;
    int[] seq;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        numCnt = Integer.parseInt(br.readLine());
        numArr = new int[numCnt];
        seq = new int[numCnt - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operatorCnt = new int[4]; // 0: +, 1: -, 2: *, 3: /
        for (int i = 0; i < 4; i++) {
            operatorCnt[i] = Integer.parseInt(st.nextToken());
        }

        getCase(0);
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private void getCase(int idx) {
        if (idx == numCnt - 1) {
            setResult();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorCnt[i] > 0) {
                operatorCnt[i]--;
                seq[idx] = i;
                getCase(idx + 1);
                operatorCnt[i]++;
            }
        }
    }
    private void setResult() {
        int result = numArr[0];

        for (int i = 1; i < numCnt; i++) {
            if (seq[i - 1] == 0) {
                result += numArr[i];
            } else if (seq[i - 1] == 1) {
                result -= numArr[i];
            } else if (seq[i - 1] == 2) {
                result *= numArr[i];
            } else if (seq[i - 1] == 3) {
                result /= numArr[i];
            }
        }

        max = Math.max(max, result);
        min = Math.min(min, result);
    }
}
