package BaekJoon.Solve2025.August.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16174 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.add(new int[]{0, 0});
        while (!q.isEmpty() && !visited[n - 1][n - 1]) {
            int[] cur = q.poll();
            int diff = map[cur[0]][cur[1]];

            if (cur[0] + diff < n && !visited[cur[0] + diff][cur[1]]) {
                visited[cur[0] + diff][cur[1]] = true;
                q.offer(new int[]{cur[0] + diff, cur[1]});
            }
            if (cur[1] + diff < n && !visited[cur[0]][cur[1] + diff]) {
                visited[cur[0]][cur[1] + diff] = true;
                q.offer(new int[]{cur[0], cur[1] + diff});
            }
        }

        if (visited[n - 1][n - 1]) {
            System.out.print("HaruHaru");
        } else {
            System.out.print("Hing");
        }

        br.close();
    }
}
