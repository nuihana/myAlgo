package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4396 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] isBomb = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                isBomb[i][j] = line.charAt(j) == '*';
            }
        }

        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
        char[][] map = new char[n][n];
        boolean isExploded = false;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '.') {
                    map[i][j] = '.';
                } else {
                    if (isBomb[i][j]) isExploded = true;

                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && isBomb[ni][nj]) {
                            cnt++;
                        }
                    }
                    map[i][j] = (char) (cnt + '0');
                }
            }
        }

        if (isExploded) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isBomb[i][j]) {
                        map[i][j] = '*';
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
