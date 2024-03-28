package BaekJoon.Solve2024.March.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1343 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int end = src.length();
        src = src.concat(".");
        char[] split = src.toCharArray();
        boolean isImpossible = false;
        for (int i = 0, len = 0; i < split.length && !isImpossible; i++) {
            if (split[i] == '.') {
                if (len > 0) {
                    if (len % 2 != 0) isImpossible = true;
                    if (len % 4 == 0) {
                        for (int j = i - len; j < i; j++) {
                            split[j] = 'A';
                        }
                    } else {
                        for (int j = i - len; j < i; j++) {
                            if (i - j > 2) split[j] = 'A';
                            else split[j] = 'B';
                        }
                    }

                    len = 0;
                }
            } else {
                len++;
            }
        }

        if (isImpossible) {
            System.out.print("-1");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < end; i++) {
                sb.append(split[i]);
            }
            System.out.print(sb);
        }

        br.close();
    }
}
