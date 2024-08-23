package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16956 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean isPossible = true;
        for (int i = 0; i < r && isPossible; i++) {
            for (int j = 0; j < c && isPossible; j++) {
                if (map[i][j] == 'W') {
                    for (int k = 0; k < 4 && isPossible; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == 'W') continue;
                        if (map[nx][ny] == 'S') isPossible = false;
                        map[nx][ny] = 'D';
                    }
                }
            }
        }

        if (isPossible) {
            StringBuilder sb = new StringBuilder();
            sb.append(1).append("\n");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } else {
            System.out.print(0);
        }

        br.close();
    }
}
