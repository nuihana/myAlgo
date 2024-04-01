package BaekJoon.Solve2024.April.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1194 {
    char[][] map;
    boolean[][][] visited;
    Block start;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        visited = new boolean[64][height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') start = new Block(i, j, 0, 0);
            }
        }

        System.out.println(search());

        br.close();
    }

    private int search() {
        Queue<Block> q = new LinkedList<>();
        q.offer(start);
        visited[0][start.row][start.col] = true;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Block now = q.poll();

            if (map[now.row][now.col] == '1') return now.cnt;

            for (int i = 0; i < 4; i++) {
                int nr = now.row + dx[i];
                int nc = now.col + dy[i];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length ||
                    map[nr][nc] == '#' || visited[now.key][nr][nc]) continue;

                if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
                    visited[now.key][nr][nc] = true;
                    q.offer(new Block(nr, nc, now.cnt + 1, now.key));
                } else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
                    int nKey = 1 << (map[nr][nc] - 'a');
                    nKey = nKey | now.key;
                    if (!visited[nKey][nr][nc]) {
                        visited[now.key][nr][nc] = true;
                        visited[nKey][nr][nc] = true;
                        q.offer(new Block(nr, nc, now.cnt + 1, nKey));
                    }
                } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
                    int door = 1 << (map[nr][nc] - 'A');
                    if ((now.key & door) > 0) {
                        visited[now.key][nr][nc] = true;
                        q.offer(new Block(nr, nc, now.cnt + 1, now.key));
                    }
                }
            }
        }

        return -1;
    }

    class Block {
        int row, col, cnt, key;

        public Block(int r, int c, int cnt, int k) {
            this.row = r;
            this.col = c;
            this.cnt = cnt;
            this.key = k;
        }
    }
}
