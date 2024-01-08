package BaekJoon.Solve2024.January.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4179 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] field = new int[row][col];
        Queue<int[]> firstQue = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char c = line.charAt(j);
                if (c == 'J') {
                    firstQue.add(new int[]{ i, j, 1 });
                    field[i][j] = 1;
                }
                if (c == 'F') {
                    firstQue.add(new int[]{ i, j, 2 });
                    field[i][j] = 2;
                }
                if (c == '#') field[i][j] = 3;
            }
        }

        int turn = 0;
        boolean chk = true;
        boolean res = false;
        Queue<int[]> secondQue = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while ((!chk || !firstQue.isEmpty()) && (chk || !secondQue.isEmpty())) {
            if (res) break;

            if (chk) {
                while (!firstQue.isEmpty()) {
                    int[] now = firstQue.poll();
                    if (field[now[0]][now[1]] != now[2]) continue;
                    if (now[2] == 1 && (now[0] == 0 || now[0] == row - 1 || now[1] == 0 || now[1] == col - 1)) {
                        res = true;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col || field[nx][ny] >= field[now[0]][now[1]]) continue;
                        field[nx][ny] = now[2];
                        secondQue.add(new int[]{ nx, ny, now[2] });
                    }
                }
            } else {
                while (!secondQue.isEmpty()) {
                    int[] now = secondQue.poll();
                    if (field[now[0]][now[1]] != now[2]) continue;
                    if (now[2] == 1 && (now[0] == 0 || now[0] == row - 1 || now[1] == 0 || now[1] == col - 1)) {
                        res = true;
                    }

                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];
                        if (nx < 0 || nx >= row || ny < 0 || ny >= col || field[nx][ny] >= field[now[0]][now[1]]) continue;
                        field[nx][ny] = now[2];
                        firstQue.add(new int[]{ nx, ny, now[2] });
                    }
                }
            }

            turn++;
            chk = !chk;
        }

        if (res) {
            System.out.print(turn);
        } else {
            System.out.print("IMPOSSIBLE");
        }

        br.close();
    }
}
