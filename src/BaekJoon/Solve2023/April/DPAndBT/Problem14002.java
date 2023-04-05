package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14002 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = new int[numCnt];
        int[] resultArr = new int[numCnt];
        int[] idxArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 1;
        resultArr[0] = numArr[0];
        idxArr[0] = 0;
        for (int i = 1; i < numCnt; i++) {
            int idx = size - 1;
            while (idx >= 0 && resultArr[idx] >= numArr[i]) {
                idx--;
            }
            resultArr[idx + 1] = numArr[i];
            idxArr[i] = idx + 1;
            if (idx == size - 1) {
                size++;
            }
        }

        bw.write(String.valueOf(size));
        bw.newLine();

        int[] backTracking = new int[size];
        for (int i = numCnt - 1; i >= 0; i--) {
            if (idxArr[i] == size - 1) {
                backTracking[size - 1] = numArr[i];
                size--;
            }
        }

        for (int i = 0; i < backTracking.length; i++) {
            bw.write(backTracking[i] + " ");
        }

        br.close();
        bw.close();
    }
}