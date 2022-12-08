package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11051 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = (factorial(a) * mod_inverse((factorial(a - b) * factorial(b)) % 10007, 10005)) % 10007;

        bw.write(Integer.toString(result));

        bw.close();
        br.close();
    }

    private int factorial(int value) {
        if (value <= 1) {
            return 1;
        }

        return (value * factorial(value - 1)) % 10007;
    }

    private int mod_inverse(int a, int p) {
        int result = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                result *= a;
                p--;
                result %= 10007;
            }

            a *= a;
            a %= 10007;
            p = p / 2;
        }
        return result;
    }
}
