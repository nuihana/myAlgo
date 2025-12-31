package BaekJoon.Solve2025.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1972 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if ("*".equals(src)) break;

            boolean isSurp = true;
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                for (int j = i + 1; j < src.length(); j++) {
                    char cp = src.charAt(j);
                    if (c == cp) {
                        for (int k = 1; j + k < src.length(); k++) {
                            if (src.charAt(i + k) == src.charAt(j + k)) isSurp = false;
                        }
                    }
                }
            }

            if (isSurp) sb.append(src).append(" is surprising.").append("\n");
            else sb.append(src).append(" is NOT surprising.").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
