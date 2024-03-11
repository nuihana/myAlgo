package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17822 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        int[][] disk = new int[cnt][size];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                disk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            rotateDisk(disk, idx, direction, amount);
            removeDuplicate(disk);
        }

        int res = 0;
        for (int[] circle : disk) {
            for (int val : circle) {
                res += val;
            }
        }
        System.out.print(res);

        br.close();
    }

    private void rotateDisk(int[][] disk, int idx, int direction, int amount) {
        for (int i = idx - 1; i < disk.length; i += idx) {
            int[] tmp = new int[disk[i].length];
            if (direction == 1) { // 반시계
                for (int j = 0; j < tmp.length; j++) {
                    tmp[j] = disk[i][(j + amount) % tmp.length];
                }
            } else { // 시계
                for (int j = 0; j < tmp.length; j++) {
                    tmp[j] = disk[i][(tmp.length + j - amount) % tmp.length];
                }
            }
            disk[i] = tmp;
        }
    }

    private void removeDuplicate(int[][] disk) {
        Set<Point> rm = new HashSet<>();
        //가로
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < disk.length; i++) {
            for (int j = 0; j < disk[i].length; j++) {
                if (disk[i][j] > 0) {
                    cnt++;
                    sum += disk[i][j];
                }
                if (disk[i][j] > 0 && disk[i][j] == disk[i][(j + 1) % disk[i].length]) {
                    rm.add(new Point(i, j));
                    rm.add(new Point(i, (j + 1) % disk[i].length));
                }
            }
        }
        //세로
        for (int j = 0; j < disk[0].length; j++) {
            for (int i = 0; i < disk.length - 1; i++) {
                if (disk[i][j] > 0 && disk[i][j] == disk[i + 1][j]) {
                    rm.add(new Point(i, j));
                    rm.add(new Point(i + 1, j));
                }
            }
        }

        if (rm.isEmpty()) {
            double avg = (double) sum / cnt;
            for (int i = 0; i < disk.length; i++) {
                for (int j = 0; j < disk[i].length; j++) {
                    if (disk[i][j] == 0) continue;
                    if (disk[i][j] > avg) {
                        disk[i][j]--;
                    } else if (disk[i][j] < avg) {
                        disk[i][j]++;
                    }
                }
            }
        } else {
            for (Point p : rm) {
                disk[p.x][p.y] = 0;
            }
        }
    }

    class Point {
        int x, y;

        public Point(int x_, int y_) {
            x = x_;
            y = y_;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;
            hash += prime * hash + x;
            hash += prime * hash + y;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Point o = (Point) obj;
            return this.x == o.x && this.y == o.y;
        }
    }
}
