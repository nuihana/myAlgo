package BaekJoon.Solve2024.August.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14405 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        boolean isPossible = true;
        for (int i = 0; i < src.length() && isPossible; i++) {
            char c = src.charAt(i);
            if (c == 'p') {
                if (i + 1 >= src.length()) {
                    isPossible = false;
                    break;
                }

                c = src.charAt(++i);
                if (c != 'i') {
                    isPossible = false;
                }
            } else if (c == 'k') {
                if (i + 1 >= src.length()) {
                    isPossible = false;
                    break;
                }

                c = src.charAt(++i);
                if (c != 'a') {
                    isPossible = false;
                }
            } else if (c == 'c') {
                if (i + 2 >= src.length()) {
                    isPossible = false;
                    break;
                }

                c = src.charAt(++i);
                if (c != 'h') {
                    isPossible = false;
                    break;
                }

                c = src.charAt(++i);
                if (c != 'u') {
                    isPossible = false;
                }
            } else {
                isPossible = false;
            }
        }

        if (isPossible) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        br.close();
    }
}
