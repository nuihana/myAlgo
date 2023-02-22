package BaekJoon.Solve2022.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2609 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int minDivisor = 1;

        for (int i = 2; i <= a && i <= b;) {
            if (a % i == 0 && b % i == 0) {
                minDivisor *= i;
                a /= i;
                b /= i;
            } else {
                i++;
            }
        }

        bw.write(minDivisor + "\n");
        bw.write(Integer.toString(a * b * minDivisor));

        bw.close();
        br.close();
    }
}
