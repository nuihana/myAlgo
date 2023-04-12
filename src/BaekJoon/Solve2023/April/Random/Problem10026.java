package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem10026 {
    int size;
    char[][] area;
    boolean[][] visited;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());
        area = new char[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            for (int j = 0; j < size; j++) {
                area[j][i] = str.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    result++;
                    dfs(i, j, true);
                }
            }
        }
        bw.write(result + " ");

        visited = new boolean[size][size];
        result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    result++;
                    dfs(i, j, false);
                }
            }
        }
        bw.write(result + "");

        br.close();
        bw.close();
    }

    private void dfs(int x, int y, boolean flag) {
        visited[x][y] = true;
        char tmp = area[x][y];

        if (y > 0 && !visited[x][y - 1] && isSameRGB(area[x][y - 1], area[x][y], flag)) {
            visited[x][y - 1] = true;
            dfs(x, y - 1, flag);
        }

        if (x < size - 1  && !visited[x + 1][y] && isSameRGB(area[x + 1][y], area[x][y], flag)) {
            visited[x + 1][y] = true;
            dfs(x + 1, y, flag);
        }

        if (y < size - 1 && !visited[x][y + 1] && isSameRGB(area[x][y + 1], area[x][y], flag)) {
            visited[x][y + 1] = true;
            dfs(x, y + 1, flag);
        }

        if (x > 0 && !visited[x - 1][y] && isSameRGB(area[x - 1][y], area[x][y], flag)) {
            visited[x - 1][y] = true;
            dfs(x - 1, y, flag);
        }
    }

    private boolean isSameRGB(char a, char b, boolean flag) {
        if (a == b) {
            return true;
        }

        if (!flag) {
            if (a == 'R' || a == 'G') {
                if (b == 'R' || b == 'G') {
                    return true;
                }
            }
        }
        return false;
    }
}
