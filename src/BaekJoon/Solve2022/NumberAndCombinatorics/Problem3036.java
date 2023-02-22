package BaekJoon.Solve2022.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem3036 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int base = Integer.parseInt(st.nextToken());

        for (int i = 0; i < input - 1; i++) {
            int nowVal = Integer.parseInt(st.nextToken());

            int gcd = (base > nowVal) ? getGreatestCommonDivisor(base, nowVal) : getGreatestCommonDivisor(nowVal, base);

            bw.write(base / gcd + "/" + nowVal / gcd + "\n");
        }

        bw.close();
        br.close();
    }

    private int getGreatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
