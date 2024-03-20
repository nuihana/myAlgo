package BaekJoon.Solve2024.March.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1080 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] input = new int[height][width];
        int[][] src = new int[height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                input[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                src[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (input[i][j] != src[i][j] && i + 2 < height && j + 2 < width) {
                    for (int r = i; r < i + 3; r++) {
                        for (int c = j; c < j + 3; c++) {
                            input[r][c] = input[r][c] == 0 ? 1 : 0;
                        }
                    }
                    cnt++;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (input[i][j] != src[i][j]) {
                    cnt = -1;
                }
            }
        }

        System.out.print(cnt);

        br.close();
    }
}
