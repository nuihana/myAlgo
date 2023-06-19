package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1987 {
    int height;
    int width;
    boolean[] used = new boolean[26];
    char[][] field;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        field = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                field[i][j] = c;
            }
        }

        used[field[0][0] - 65] = true;
        bw.write(String.valueOf(dfs(0, 0, 1)));

        br.close();
        bw.close();
    }

    private int dfs(int x, int y, int depth) {
        int result = depth;

        if (x > 0 && !used[field[x - 1][y] - 65]) {
            used[field[x - 1][y] - 65] = true;
            result = Math.max(result, dfs(x - 1, y, depth + 1));
            used[field[x - 1][y] - 65] = false;
        }

        if (y < width - 1 && !used[field[x][y + 1] - 65]) {
            used[field[x][y + 1] - 65] = true;
            result = Math.max(result, dfs(x, y + 1, depth + 1));
            used[field[x][y + 1] - 65] = false;
        }

        if (x < height - 1 && !used[field[x + 1][y] - 65]) {
            used[field[x + 1][y] - 65] = true;
            result = Math.max(result, dfs(x + 1, y, depth + 1));
            used[field[x + 1][y] - 65] = false;
        }

        if (y > 0 && !used[field[x][y - 1] - 65]) {
            used[field[x][y - 1] - 65] = true;
            result = Math.max(result, dfs(x, y - 1, depth + 1));
            used[field[x][y - 1] - 65] = false;
        }

        return result;
    }
}
