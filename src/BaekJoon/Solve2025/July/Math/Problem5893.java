package BaekJoon.Solve2025.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5893 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String plus = src.concat("0000");

        StringBuilder sb = new StringBuilder();
        int up = 0;
        for (int i = 0; i < plus.length(); i++) {
            int n = plus.charAt(plus.length() - 1 - i) - '0';
            if (i < src.length()) {
                int pn = src.charAt(src.length() - 1 - i) - '0';

                n += pn;
            }

            n += up;
            up = 0;

            if (n >= 2) {
                up = 1;
                n -= 2;
            }

            sb.append(n);
        }

        if (up > 0) {
            sb.append(1);
        }

        System.out.print(sb.reverse());

        br.close();
    }
}
