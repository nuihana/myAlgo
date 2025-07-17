package BaekJoon.Solve2025.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11816 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 0;
        if (src.length() > 1 && src.substring(0, 2).equals("0x")) { // 16진수
            for (int i = 0; i < src.length() - 2; i++) {
                int mul = (int) Math.pow(16, i);
                char c = src.charAt(src.length() - 1 - i);

                int now = 0;
                if (c >= '0' && c <= '9') {
                    now = c - '0';
                } else {
                    now = c - 'a' + 10;
                }

                res += mul * now;
            }
        } else if (src.charAt(0) == '0') { // 8진수
            for (int i = 0; i < src.length() - 1; i++) {
                int mul = (int) Math.pow(8, i);
                int now = src.charAt(src.length() - 1 - i) - '0';

                res += mul * now;
            }
        } else {
            res = Integer.parseInt(src);
        }
        System.out.print(res);

        br.close();
    }
}
