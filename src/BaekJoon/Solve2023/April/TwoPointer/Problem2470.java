package BaekJoon.Solve2023.April.TwoPointer;

import java.io.*;
import java.util.*;

public class Problem2470 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        int left = 0;
        int right = numCnt - 1;
        int tmpSum = Integer.MAX_VALUE;
        int lIdx = 0;
        int rIdx = 0;
        while (left < right) {
            int tmp = numArr[left] + numArr[right];

            tmpSum = Math.min(tmpSum, Math.abs(tmp));

            if (tmpSum == Math.abs(tmp)) {
                lIdx = left;
                rIdx = right;
            }

            if (tmp == 0) {
                break;
            }

            if (tmp > 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(numArr[lIdx] + " " + numArr[rIdx]);

        br.close();
        bw.close();
    }
}
