package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17837 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int pieceCnt = Integer.parseInt(st.nextToken());

        List<Integer>[][] height = new List[size][size];
        int[][] map = new int[size][size]; // 0 : 흰색, 1 : 빨간색, 2 : 파란색
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height[i][j] = new ArrayList<>();
            }
        }

        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < pieceCnt; i++) {
            st = new StringTokenizer(br.readLine());

            Piece p = new Piece(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            pieces.add(p);
            height[p.x][p.y].add(i);
        }

        int[] dx = { 0, 0, 0, -1, 1 };
        int[] dy = { 0, 1, -1, 0, 0 };
        int turn = 0;
        while (turn < 1000) {
            turn++;

            for (int i = 0; i < pieceCnt; i++) {
                Piece now = pieces.get(i);

                int nx = now.x + dx[now.direction];
                int ny = now.y + dy[now.direction];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                    if (map[nx][ny] == 0) { // 흰색
                        int index = height[now.x][now.y].indexOf(i);

                        height[nx][ny].addAll(height[now.x][now.y].subList(index, height[now.x][now.y].size()));
                        height[now.x][now.y] = height[now.x][now.y].subList(0, index);

                        pieces.get(i).x = nx;
                        pieces.get(i).y = ny;

                        for (Integer id : height[nx][ny]) {
                            pieces.get(id).x = nx;
                            pieces.get(id).y = ny;
                        }
                    } else if (map[nx][ny] == 1) { // 빨간색 > 수직 거꾸로
                        int index = height[now.x][now.y].indexOf(i);
                        List<Integer> subList = height[now.x][now.y].subList(index, height[now.x][now.y].size());
                        Collections.reverse(subList);

                        height[nx][ny].addAll(subList);
                        height[now.x][now.y] = height[now.x][now.y].subList(0, index);

                        for (Integer id : height[nx][ny]) {
                            pieces.get(id).x = nx;
                            pieces.get(id).y = ny;
                        }
                    } else if (map[nx][ny] == 2) {
                        now.reverse();

                        if (now.x + dx[now.direction] < 0 || now.x + dx[now.direction] >= size || now.y + dy[now.direction] < 0 || now.y + dy[now.direction] >= size) continue;
                        if (map[now.x + dx[now.direction]][now.y + dy[now.direction]] != 2) i--;
                    }

                    if (height[nx][ny].size() > 3) {
                        System.out.print(turn);
                        return;
                    }
                } else {
                    now.reverse();
                    if (map[now.x + dx[now.direction]][now.y + dy[now.direction]] != 2) i--;
                }
            }
        }

        System.out.print(-1);

        br.close();
    }

    class Piece {
        int x, y, direction; // 1 : 오, 2 : 왼, 3 : 위, 4 : 아래

        public Piece(int x_, int y_, int d_) {
            x = x_;
            y = y_;
            direction = d_;
        }

        public void reverse() {
            if (direction == 1) direction = 2;
            else if (direction == 2) direction = 1;
            else if (direction == 3) direction = 4;
            else if (direction == 4) direction = 3;
        }
    }
}
