package BaekJoon.Solve2024.September.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem11123 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
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

            int res = 0;
            boolean[][] isCount = new boolean[row][col];
            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == '#' && !isCount[i][j]) {
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{ i, j });
                        isCount[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= row || ny < 0 || ny >= col || isCount[nx][ny] || map[nx][ny] != '#') continue;
                                q.offer(new int[]{ nx, ny });
                                isCount[nx][ny] = true;
                            }
                        }
                        res++;
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
