package BaekJoon.Solve2023.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1629 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] binaryB = new int[32];
        int maximumB = 0;

        for (int i = 0; b != 1; i++) {
            binaryB[i] = b % 2;
            b = b / 2;
            maximumB = i + 1;
        }
        binaryB[maximumB] = b;

        long[] sqrModulerC = new long[maximumB + 1];
        sqrModulerC[0] = a % c;
        for (int i = 1; i <= maximumB; i++) {
            sqrModulerC[i] = (sqrModulerC[i - 1] * sqrModulerC[i - 1]) % c;
        }

        long tmp = -1;
        for (int i = 0; i < maximumB + 1; i++) {
            if(binaryB[i] > 0) {
                if (tmp < 0) {
                    tmp = sqrModulerC[i];
                } else {
                    tmp = ((tmp % c) * (sqrModulerC[i] % c)) % c;
                }
            }
        }

        bw.write(Long.toString(tmp));

        br.close();
        bw.close();
    }
}
