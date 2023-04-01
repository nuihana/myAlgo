package BaekJoon.Solve2023.March.DivisorMultiplePrimeNumQuick;

import java.io.*;
import java.util.StringTokenizer;

public class Problem13241 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long numA = Long.parseLong(st.nextToken());
        long numB = Long.parseLong(st.nextToken());

        int sqrtNum = (int) Math.ceil(Math.sqrt(Math.max(numA, numB)));
        int multiple = 1;

        for (int i = 2; i <= sqrtNum; i++) {
            while (numA % i == 0 && numB % i == 0) {
                numA /= i;
                numB /= i;
                multiple *= i;
            }
        }

        bw.write(String.valueOf(numA * numB * multiple));

        br.close();
        bw.close();
    }
}
