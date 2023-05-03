package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.Arrays;

public class Problem2217 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ropeCnt = Integer.parseInt(br.readLine());
        int[] ropeArr = new int[ropeCnt];
        for (int i = 0; i < ropeCnt; i++) {
            ropeArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropeArr);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < ropeCnt; i++) {
            result = Math.max(result, ropeArr[i] * (ropeCnt - i));
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
