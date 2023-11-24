package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2469 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] purpose = br.readLine().toCharArray();
        Ladder[][] ladders = new Ladder[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                ladders[i][j] = new Ladder();
            }
        }

        int findLine = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line.charAt(0) == '?') {
                findLine = i;
                continue;
            }

            for (int j = 0; j < k - 1; j++) {
                if (line.charAt(j) == '-') {
                    ladders[i][j].right = true;
                    ladders[i][j + 1].left = true;
                }
            }
        }

        char[] topDown = new char[k];
        for (int i = 0; i < k; i++) {
            int loc = i;
            for (int j = 0; j < findLine; j++) {
                loc += ladders[j][loc].move();
            }
            topDown[loc] = (char) ('A' + i);
        }

        char[] bottomUp = new char[k];
        for (int i = 0; i < k; i++) {
            int loc = i;
            for (int j = n - 1; j > findLine; j--) {
                loc += ladders[j][loc].move();
            }
            bottomUp[loc] = purpose[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (topDown[i] == bottomUp[i]) {
                sb.append('*');
            } else {
                if (topDown[i] == bottomUp[i + 1] && topDown[i + 1] == bottomUp[i]) {
                    sb.append('-');
                    if (i < k - 2) sb.append('*');
                    i++;
                } else {
                    sb.setLength(0);
                    for (int j = 0; j < k - 1; j++) {
                        sb.append('x');
                    }
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }

    class Ladder {
        boolean left = false;
        boolean right = false;

        public int move() {
            if (left) return -1;
            else if (right) return 1;
            return 0;
        }
    }
}
