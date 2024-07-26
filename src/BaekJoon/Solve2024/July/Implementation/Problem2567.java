package BaekJoon.Solve2024.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2567 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int paperCnt = Integer.parseInt(br.readLine());
        int[][] field = new int[101][101];
        for (int i = 0; i < paperCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    field[j][k] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (field[i][j] == 1) {
                    int[] dx = { -1, 0, 1, 0 };
                    int[] dy = { 0, 1, 0, -1 };

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx > 100 || ny < 0 || ny > 100 || field[nx][ny] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
