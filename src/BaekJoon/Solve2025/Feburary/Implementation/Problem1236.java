package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1236 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] map = new char[h][w];
        int row = 0;
        for (int i = 0; i < h; i++) {
            String floor  = br.readLine();
            boolean isEmpty = true;
            for (int j = 0; j < w; j++) {
                map[i][j] = floor.charAt(j);
                if (map[i][j] == 'X') isEmpty = false;
            }

            if (isEmpty) row++;
        }

        int col = 0;
        for (int i = 0; i < w; i++) {
            boolean isEmpty = true;
            for (int j = 0; j < h; j++) {
                if (map[j][i] == 'X') isEmpty = false;
            }
            if (isEmpty) col++;
        }
        System.out.print(Math.max(row, col));

        br.close();
    }
}
