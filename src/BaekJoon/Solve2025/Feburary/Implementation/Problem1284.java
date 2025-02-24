package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1284 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();

            if ("0".equals(src)) break;

            int res = src.length() + 1;
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (c == '1') {
                    res += 2;
                } else if (c == '0') {
                    res += 4;
                } else {
                    res += 3;
                }
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
