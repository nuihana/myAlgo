package BaekJoon.Solve2025.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2999 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int n = src.length(), R = 0, C = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                R = i;
                C = n / i;
            }
        }

        int cnt = 0;
        char[][] map = new char[R][C];
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                map[r][c] = src.charAt(cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c]);
            }
        }
        System.out.print(sb);

        br.close();
    }
}
