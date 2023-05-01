package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1026 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        int[] aArr = new int[numCnt];
        Integer[] bArr = new Integer[numCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < numCnt; i++) {
            result += aArr[i] * bArr[numCnt - 1 - i];
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
