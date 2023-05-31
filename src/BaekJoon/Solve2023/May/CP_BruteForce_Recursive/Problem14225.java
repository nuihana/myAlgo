package BaekJoon.Solve2023.May.CP_BruteForce_Recursive;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14225 {
    int[] numArr;
    int[] seq;
    int[] result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        seq = new int[numCnt];
        result = new int[2000001];
        for (int i = 1; i <= numCnt; i++) {
            sequence(i, 0, 0);
        }

        for (int i = 1; i < result.length; i++) {
            if (result[i] == 0) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        br.close();
        bw.close();
    }

    private void sequence(int len, int idx, int start) {
        if (idx == len) {
            setCase(len);
            return;
        }

        for (int i = start; i < seq.length; i++) {
            seq[idx] = i;
            sequence(len, idx + 1, i + 1);
        }
    }
    private void setCase(int size) {
        int num = 0;
        for (int i = 0; i < size; i++) {
            num += numArr[seq[i]];
        }
        result[num]++;
    }
}
