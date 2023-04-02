package BaekJoon.Solve2023.April.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1806 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int purposeNum = Integer.parseInt(st.nextToken());
        int[] numArr = new int[numCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;
        int summary = numArr[start];
        while (end < numCnt && start <= end) {
            if (summary >= purposeNum) {
                minLength = Math.min(minLength, end - start + 1);
            }

            if (summary >= purposeNum) {
                summary -= numArr[start];
                start++;
            } else {
                end++;
                if (end >= numCnt) {
                    break;
                }
                summary += numArr[end];
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(minLength));
        }

        br.close();
        bw.close();
    }
}
