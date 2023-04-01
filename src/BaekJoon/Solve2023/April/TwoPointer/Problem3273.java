package BaekJoon.Solve2023.April.TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3273 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);
        int resNum = Integer.parseInt(br.readLine());
        int result = 0;
        int left = 0;
        int right = numCnt - 1;
        while (left < right) {
            int tmp = numArr[left] + numArr[right];
            if (tmp == resNum) {
                result++;
            }

            if (tmp > resNum) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
