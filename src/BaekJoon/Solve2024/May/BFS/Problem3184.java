package BaekJoon.Solve2024.May.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3184 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[row][col];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != '#' && !isVisited[i][j]) {
                    q.offer(new int[]{ i, j });
                    isVisited[i][j] = true;

                    int v = 0;
                    int o = 0;
                    if (map[i][j] == 'v') v++;
                    if (map[i][j] == 'o') o++;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];

                            if (nx < 0 || nx >= row || ny < 0 || ny >= col || map[nx][ny] == '#' || isVisited[nx][ny]) continue;
                            isVisited[nx][ny] = true;
                            if (map[nx][ny] == 'v') v++;
                            if (map[nx][ny] == 'o') o++;
                            q.offer(new int[]{ nx, ny });
                        }
                    }

                    if (o > v) {
                        sheep += o;
                    } else {
                        wolf += v;
                    }
                }
            }
        }

        System.out.print(sheep + " " + wolf);

        br.close();
    }
}
