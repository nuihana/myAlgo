package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem6593 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            int[][][] building = new int[l][r][c];
            int[] start = new int[4];
            int[] end = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char ch = line.charAt(k);

                        if (ch == 'S') {
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        }

                        if (ch == 'E') {
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }

                        if (ch == '#') {
                            building[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> q = new LinkedList<>();
            boolean[][][] isVisited = new boolean[l][r][c];
            q.offer(start);
            isVisited[start[0]][start[1]][start[2]] = true;

            int[] dx = { -1, 0, 1, 0, 0, 0 };
            int[] dy = { 0, 1, 0, -1, 0, 0 };
            int[] dz = { 0, 0, 0, 0, 1, -1 };
            int res = -1;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (now[0] == end[0] && now[1] == end[1] && now[2] == end[2]) {
                    res = now[3];
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int[] next = { now[0] + dz[i], now[1] + dx[i], now[2] + dy[i], now[3] + 1 };

                    if (next[0] < 0 || next[0] >= l || next[1] < 0 || next[1] >= r ||
                        next[2] < 0 || next[2] >= c || isVisited[next[0]][next[1]][next[2]] ||
                        building[next[0]][next[1]][next[2]] == 1) continue;
                    isVisited[next[0]][next[1]][next[2]] = true;
                    q.offer(next);
                }
            }

            if (res == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + res + " minute(s).");
            }
        }

        br.close();
    }
}
