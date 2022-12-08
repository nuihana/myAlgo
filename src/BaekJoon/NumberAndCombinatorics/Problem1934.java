package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1934 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int minDivisor = 1;

            for (int j = 2; j <= a && j <= b;) {
                if (a % j == 0 && b % j == 0) {
                    minDivisor *= j;
                    a /= j;
                    b /= j;
                } else {
                    j++;
                }
            }

            bw.write(minDivisor + "\n");
            bw.write(Integer.toString(a * b * minDivisor));
        }

        bw.close();
        br.close();
    }
}
