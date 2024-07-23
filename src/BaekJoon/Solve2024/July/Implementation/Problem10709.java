package BaekJoon.Solve2024.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem10709 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            Arrays.fill(map[i], -1);
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                if (c == 'c') {
                    map[i][j] = 0;
                    q.offer(new int[]{ i, j, 0 });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int nx = now[0];
            int ny = now[1] + 1;

            if (ny >= width || map[nx][ny] > -1) continue;
            map[nx][ny] = now[2] + 1;
            q.offer(new int[]{ nx, ny, now[2] + 1 });
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
