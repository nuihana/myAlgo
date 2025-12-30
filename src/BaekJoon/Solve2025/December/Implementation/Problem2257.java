package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Queue;

public class Problem2257 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        System.out.print(getMass(src));

        br.close();
    }

    private int getMass(String src) {
        int res = 0;

        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == '(') {
                int cnt = 0;
                StringBuilder sb = new StringBuilder();
                while (src.charAt(++i) != ')' || cnt != 0) {
                    if (src.charAt(i) == '(') cnt++;
                    else if (src.charAt(i) == ')') cnt--;

                    sb.append(src.charAt(i));
                }

                if (src.length() > i + 1 && src.charAt(i + 1) >= '2' && src.charAt(i + 1) <= '9') {
                    res += getMass(sb.toString()) * (src.charAt(++i) - '0');
                } else {
                    res += getMass(sb.toString());
                }
            } else {
                int tmp = 0;

                if (src.charAt(i) == 'C') {
                    tmp = 12;
                } else if (src.charAt(i) == 'H') {
                    tmp = 1;
                } else if (src.charAt(i) == 'O') {
                    tmp = 16;
                }

                if (src.length() > i + 1 && src.charAt(i + 1) >= '2' && src.charAt(i + 1) <= '9') {
                    tmp *= (src.charAt(++i) - '0');
                }

                res += tmp;
            }
        }

        return res;
    }
}
