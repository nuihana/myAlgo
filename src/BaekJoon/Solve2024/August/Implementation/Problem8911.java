package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8911 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String query = br.readLine();

            int top = 0, bottom = 0, left = 0, right = 0;
            int x = 0, y = 0, direction = 0; // 0: 북, 1: 동, 2: 남, 3: 서
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);

                if (c == 'F') {
                    int[] next = move(x, y, direction, true);
                    x = next[0];
                    y = next[1];
                } else if (c == 'B') {
                    int[] next = move(x, y, direction, false);
                    x = next[0];
                    y = next[1];
                } else if (c == 'L') {
                    if (direction == 0) direction = 3;
                    else direction -= 1;
                } else if (c == 'R') {
                    if (direction == 3) direction = 0;
                    else direction += 1;
                }

                top = Math.max(top, y);
                bottom = Math.min(bottom, y);
                left = Math.min(left, x);
                right = Math.max(right, x);
            }

            sb.append((top - bottom) * (right - left)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int[] move(int x, int y, int direction, boolean pos) {
        if (direction == 0) {
            if (pos) {
                y += 1;
            } else {
                y -= 1;
            }
        } else if (direction == 1) {
            if (pos) {
                x += 1;
            } else {
                x -= 1;
            }
        } else if (direction == 2) {
            if (pos) {
                y -= 1;
            } else {
                y += 1;
            }
        } else if (direction == 3) {
            if (pos) {
                x -= 1;
            } else {
                x += 1;
            }
        }
        return new int[]{ x, y };
    }
}
