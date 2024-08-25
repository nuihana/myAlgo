package BaekJoon.Solve2024.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1212 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            int n = c - '0';
            if (i == 0) {
                sb.append(Integer.toBinaryString(n));
            } else {
                sb.append(fillLeft(Integer.toBinaryString(n)));
            }
        }
        System.out.print(sb);

        br.close();
    }

    private String fillLeft(String src) {
        while (src.length() < 3) {
            src = "0".concat(src);
        }
        return src;
    }
}
