package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem21610 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int fieldSize = Integer.parseInt(st.nextToken());
        int moveCnt = Integer.parseInt(st.nextToken());
        int[][] field = new int[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
        int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] cdx = { -1, -1, 1, 1 };
        int[] cdy = { -1, 1, 1, -1 };
        List<Point> cloud = new ArrayList<>();
        cloud.add(new Point( fieldSize - 1, 0 ));
        cloud.add(new Point( fieldSize - 1, 1 ));
        cloud.add(new Point( fieldSize - 2, 0 ));
        cloud.add(new Point( fieldSize - 2, 1 ));
        while (moveCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            int dxSum = dx[direction] * distance;
            int dySum = dy[direction] * distance;

            //구름 이동 + 비내림
            for (Point p : cloud) {
                p.x = (p.x + fieldSize * 50 + dxSum) % fieldSize;
                p.y = (p.y + fieldSize * 50 + dySum) % fieldSize;

                field[p.x][p.y]++;
            }

            Set<Point> cloudedSet = new HashSet<>();

            //비가 내린 곳에 물 복사
            for (Point p : cloud) {
                int amount = 0;
                for (int i = 0; i < 4; i++) {
                    int chkX = p.x + cdx[i];
                    int chkY = p.y + cdy[i];
                    if (chkX < 0 || chkX >= fieldSize || chkY < 0 || chkY >= fieldSize || field[chkX][chkY] == 0) continue;
                    amount++;
                }
                field[p.x][p.y] += amount;

                cloudedSet.add(p);
            }

            //구름 초기화
            cloud.clear();

            //다음 구름 세팅
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (field[i][j] >= 2) {
                        Point p = new Point(i, j);
                        if (!cloudedSet.contains(p)) {
                            field[i][j] -= 2;
                            cloud.add(p);
                        }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                res += field[i][j];
            }
        }
        System.out.print(res);

        br.close();
    }

    class Point {
        int x, y;

        public Point(int x_, int y_) {
            x = x_;
            y = y_;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
