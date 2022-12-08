package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2981 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int[] valArr = new int[input];

        for (int i = 0; i < input; i++) {
            valArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(valArr);

        int gcdVal = valArr[1] - valArr[0];

        for (int i = 2; i < input; i++) {
            gcdVal = gcd(gcdVal, valArr[i] - valArr[i - 1]);
        }

        for (int i = 2; i <= gcdVal / 2; i++) {
            if (gcdVal % i == 0) {
                bw.write(i + " ");
            }
        }

        bw.write(Integer.toString(gcdVal));

        bw.close();
        br.close();
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
