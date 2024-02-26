package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem18405 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int virusCnt = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            return a1[3] - a2[3];
        });
        int[][] field = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] != 0) {
                    q.offer(new int[]{ 0, i, j, field[i][j] });
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] >= time) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[2] + dy[i];
                if (nx < 0 || nx >= size || ny < 0 || ny >= size || field[nx][ny] != 0) continue;
                field[nx][ny] = now[3];
                q.offer(new int[]{ now[0] + 1, nx, ny, now[3] });
            }
        }

        System.out.print(field[ex][ey]);

        br.close();
    }
}
