package BaekJoon.Solve2025.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Problem10253 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x, a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            while (a != 1) {
                x = (b % a == 0) ? b / a : b / a + 1;
                a = a * x - b;
                b *= x;
                int gcd = GCD(a, b);
                a /= gcd;
                b /= gcd;
            }
            sb.append(b).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
