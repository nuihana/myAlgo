package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10157 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        if (row * col >= n) {
            int bottom = 1, left = 2;
            int x = 1, y = 1, dir = 0;
            while (n-- > 0) {
                if (dir == 0) {
                    y++;
                    if (y == col) {
                        dir += 1;
                        col--;
                    }
                } else if (dir == 1) {
                    x++;
                    if (x == row) {
                        dir += 1;
                        row--;
                    }
                } else if (dir == 2) {
                    y--;
                    if (y == bottom) {
                        dir += 1;
                        bottom++;
                    }
                } else if (dir == 3) {
                    x--;
                    if (x == left) {
                        dir = 0;
                        left++;
                    }
                }
            }

            System.out.print(x + " " + y);
        } else {
            System.out.print("0");
        }

        br.close();
    }
}
