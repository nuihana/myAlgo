package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem17144 {
    int height;
    int width;
    int[][] field;
    Point[] cleaner;
    List<Point> spreadDurtList;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        field = new int[height][width];

        cleaner = new Point[2];
        spreadDurtList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());

                if (cleaner[0] == null && field[i][j] == -1) {
                    cleaner[0] = new Point(i, j);
                    cleaner[1] = new Point(i + 1, j);
                } else if (field[i][j] >= 5) {
                    spreadDurtList.add(new Point(i, j, field[i][j]));
                }
            }
        }

        while(time > 0) {
            doSpread();
            doClean();
            chkDurt();
            time--;
        }

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j] > 0) {
                    result += field[i][j];
                }
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private void doSpread() {
        for (Point p : spreadDurtList) {
            int spread = p.dust / 5;

            int spreadCnt = 0;
            if (p.x > 0 && field[p.x - 1][p.y] != -1) {
                field[p.x - 1][p.y] += spread;
                spreadCnt++;
            }

            if (p.y < width - 1 && field[p.x][p.y + 1] != -1) {
                field[p.x][p.y + 1] += spread;
                spreadCnt++;
            }

            if (p.x < height - 1 && field[p.x + 1][p.y] != -1) {
                field[p.x + 1][p.y] += spread;
                spreadCnt++;
            }

            if (p.y > 0 && field[p.x][p.y - 1] != -1) {
                field[p.x][p.y - 1] += spread;
                spreadCnt++;
            }

            field[p.x][p.y] -= spread * spreadCnt;
        }

        spreadDurtList.clear();
    }
    private void doClean() {
        // 위쪽
        int x = cleaner[0].x - 1;
        int y = cleaner[0].y;
        while (x > 0) {
            field[x][y] = field[x - 1][y];
            x--;
        }
        while (y < width - 1) {
            field[x][y] = field[x][y + 1];
            y++;
        }
        while (x < cleaner[0].x) {
            field[x][y] = field[x + 1][y];
            x++;
        }
        while (y > 1) {
            field[x][y] = field[x][y - 1];
            y--;
        }
        field[x][y] = 0;

        // 아래쪽
        x = cleaner[1].x + 1;
        y = cleaner[1].y;
        while (x < height - 1) {
            field[x][y] = field[x + 1][y];
            x++;
        }
        while (y < width - 1) {
            field[x][y] = field[x][y + 1];
            y++;
        }
        while (x > cleaner[1].x) {
            field[x][y] = field[x - 1][y];
            x--;
        }
        while (y > 1) {
            field[x][y] = field[x][y - 1];
            y--;
        }
        field[x][y] = 0;
    }
    private void chkDurt() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j] >= 5) {
                    spreadDurtList.add(new Point(i, j, field[i][j]));
                }
            }
        }
    }

    class Point {
        int x;
        int y;
        int dust;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
        public Point(int x_, int y_, int dust_) {
            this.x = x_;
            this.y = y_;
            this.dust = dust_;
        }
    }
}
