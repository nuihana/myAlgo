package BaekJoon.Solve2024.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3613 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (src.charAt(0) <= '_' || src.charAt(src.length() - 1) == '_') {
            System.out.print("Error!");
            return;
        }

        boolean upperCase = false;
        boolean isJava = false;
        char pre = src.charAt(0);
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c <= 'Z') {
                if (isJava) {
                    System.out.print("Error!");
                    return;
                }
                upperCase = true;
            }

            if (c == '_') {
                if (upperCase || pre == '_') {
                    System.out.print("Error!");
                    return;
                }
                isJava = true;
            }

            pre = c;
        }

        if (isJava) {
            boolean nextUpper = false;
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (nextUpper) {
                    sb.append(String.valueOf(c).toUpperCase());
                    nextUpper = false;
                } else {
                    if (src.charAt(i) == '_') nextUpper = true;
                    else sb.append(c);
                }
            }
        } else {
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (c <= 'Z') {
                    sb.append("_");
                    sb.append(String.valueOf(c).toLowerCase());
                } else {
                    sb.append(c);
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}
