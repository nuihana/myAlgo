package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1996 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
        int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = map[i][j];

                if (c == '.') {
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                            if (map[nx][ny] != '.') cnt += map[nx][ny] - '0';
                        }
                    }

                    if (cnt < 10) {
                        sb.append(cnt);
                    } else {
                        sb.append("M");
                    }
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
