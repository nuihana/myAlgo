package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1926 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isUsed = new boolean[row][col];

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1 && !isUsed[i][j]) {
                    q.offer(new int[]{ i, j });
                    isUsed[i][j] = true;

                    int size = 0;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        size++;

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= row || ny < 0 || ny >= col || isUsed[nx][ny] || arr[nx][ny] == 0) continue;
                            isUsed[nx][ny] = true;
                            q.offer(new int[]{ nx, ny });
                        }
                    }
                    res.add(size);
                }
            }
        }

        res.sort(Comparator.reverseOrder());
        System.out.println(res.size());
        System.out.print(res.isEmpty() ? 0 : res.get(0));

        br.close();
    }
}
