package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem2667 {
    int[][] field;
    boolean[][] visited;
    int fieldSize;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        fieldSize = Integer.parseInt(br.readLine());
        field = new int[fieldSize][fieldSize];
        visited = new boolean[fieldSize][fieldSize];
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < fieldSize; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = Integer.parseInt(tmp.substring(j, j + 1));
            }
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == 1 && !visited[i][j]) {
                    resultList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(resultList);

        bw.write(String.valueOf(resultList.size()));
        bw.newLine();
        for (int val : resultList) {
            bw.write(String.valueOf(val));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int bfs(int x, int y) {
        int set = 1;
        visited[x][y] = true;

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y));

        while(!que.isEmpty()) {
            Point tmp = que.poll();

            if (tmp.x > 0 && !visited[tmp.x - 1][tmp.y] && field[tmp.x - 1][tmp.y] == 1) {
                set++;
                visited[tmp.x - 1][tmp.y] = true;
                que.add(new Point(tmp.x - 1, tmp.y));
            }

            if (tmp.y < fieldSize - 1 && !visited[tmp.x][tmp.y + 1] && field[tmp.x][tmp.y + 1] == 1) {
                set++;
                visited[tmp.x][tmp.y + 1] = true;
                que.add(new Point(tmp.x, tmp.y + 1));
            }

            if (tmp.x < fieldSize - 1 && !visited[tmp.x + 1][tmp.y] && field[tmp.x + 1][tmp.y] == 1) {
                set++;
                visited[tmp.x + 1][tmp.y] = true;
                que.add(new Point(tmp.x + 1, tmp.y));
            }

            if (tmp.y > 0 && !visited[tmp.x][tmp.y - 1] && field[tmp.x][tmp.y - 1] == 1) {
                set++;
                visited[tmp.x][tmp.y - 1] = true;
                que.add(new Point(tmp.x, tmp.y - 1));
            }
        }

        return set;
    }

    class Point {
        int x;
        int y;
        public Point(int inX, int inY) {
            this.x = inX;
            this.y = inY;
        }
    }
}
