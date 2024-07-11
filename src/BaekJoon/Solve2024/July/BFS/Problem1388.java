package BaekJoon.Solve2024.July.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1388 {
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

        boolean[][] isCounted = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!isCounted[i][j]) {
                    char c = map[i][j];

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ i, j });
                    isCounted[i][j] = true;
                    if (c == '-') {
                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            int ny = now[1] + 1;
                            if (ny >= col || isCounted[now[0]][ny] || map[now[0]][ny] == '|') continue;
                            isCounted[now[0]][ny] = true;
                            q.offer(new int[]{ now[0], ny });
                        }
                    } else {
                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            int nx = now[0] + 1;
                            if (nx >= row || isCounted[nx][now[1]] || map[nx][now[1]] == '-') continue;
                            isCounted[nx][now[1]] = true;
                            q.offer(new int[]{ nx, now[1] });
                        }
                    }
                    res++;
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
