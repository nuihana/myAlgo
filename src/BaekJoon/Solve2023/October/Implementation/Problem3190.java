package BaekJoon.Solve2023.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem3190 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            field[c - 1][r - 1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(x, c);
        }

        final int[] dx = { 0, 1, 0, -1 };
        final int[] dy = { 1, 0, -1, 0 };
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{ 0, 0 });

        int turn = 0;
        int direction = 0;
        int cx = 0, cy = 0;
        while (true) {
            turn++;

            int nx = cx + dx[direction];
            int ny = cy + dy[direction];

            if (isFinish(nx, ny, n, snake)) break;

            if (field[nx][ny] == 1) {
                field[nx][ny] = 0;
                snake.add(new int[] { nx, ny });

            } else {
                snake.add(new int[] { nx, ny });
                snake.remove(0);
            }

            if (map.containsKey(turn)) {
                if (map.get(turn).equals("D")) {
                    direction += 1;
                    if (direction == 4)
                        direction = 0;
                } else {
                    direction -= 1;
                    if (direction == -1)
                        direction = 3;
                }
            }

            cx = nx;
            cy = ny;
        }
        System.out.print(turn);

        br.close();
    }

    private boolean isFinish(int nx, int ny, int n, List<int[]> snake) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] t = snake.get(i);
            if (nx == t[0] && ny == t[1])
                return true;
        }
        return false;
    }
}
