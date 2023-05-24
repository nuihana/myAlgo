package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.*;

public class Problem1917 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            List<Point> cubePlane = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 6; k++) {
                    int p = Integer.parseInt(st.nextToken());
                    if (p == 1) {
                        cubePlane.add(new Point(j, k));
                    }
                }
            }

            Cube cube = new Cube(cubePlane);
            for (int j = 1; j < cubePlane.size(); j++) {
                cube.move(cubePlane.get(j));
            }

            if (cube.isCube()) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }

    class Cube {
        int[] sideArr = new int[6]; // 0: 바닥, 1: 북, 2: 동, 3: 남, 4: 서, 5: 위
        int[][] field = new int[6][6];
        boolean chk = true;
        Point now;

        public Cube(List<Point> pList) {
            this.now = pList.get(0);
            sideArr[0] = 1;

            for (Point p : pList) {
                field[p.x][p.y] = 1;
            }
        }

        private void chk() {
            if (sideArr[0] == 1) {
                chk = false;
            }
            sideArr[0] = 1;
        }
        private void rotateLeft() {
            // 4 -> 0
            int tmp = sideArr[0];
            sideArr[0] = sideArr[4];
            // 0 -> 2
            int tmp_ = sideArr[2];
            sideArr[2] = tmp;
            // 2 -> 5
            tmp = sideArr[5];
            sideArr[5] = tmp_;
            // 5 -> 4
            sideArr[4] = tmp;
        }
        private void rotateRight() {
            // 0 -> 4
            int tmp = sideArr[4];
            sideArr[4] = sideArr[0];
            // 4 -> 5
            int tmp_ = sideArr[5];
            sideArr[5] = tmp;
            // 5 -> 2
            tmp = sideArr[2];
            sideArr[2] = tmp_;
            // 2 -> 0
            sideArr[0] = tmp;
        }
        private void rotateUp() {
            // 0 -> 3
            int tmp = sideArr[3];
            sideArr[3] = sideArr[0];
            // 3 -> 5
            int tmp_ = sideArr[5];
            sideArr[5] = tmp;
            // 5 -> 1
            tmp = sideArr[1];
            sideArr[1] = tmp_;
            // 1 -> 0
            sideArr[0] = tmp;
        }
        private void rotateDown() {
            // 0 -> 1
            int tmp = sideArr[1];
            sideArr[1] = sideArr[0];
            // 1 -> 5
            int tmp_ = sideArr[5];
            sideArr[5] = tmp;
            // 5 -> 3
            tmp = sideArr[3];
            sideArr[3] = tmp_;
            // 3 -> 0
            sideArr[0] = tmp;
        }

        public void move(Point to) {
            Queue<Path> que = new LinkedList<>();
            boolean[][] visited = new boolean[6][6];
            que.offer(new Path(now));
            visited[now.x][now.y] = true;
            Path path = null;
            while(!que.isEmpty()) {
                Path p = que.poll();

                if (p.isReach(to)) {
                    path = p;
                    break;
                }

                Point po = p.idx;
                if (po.x > 0 && field[po.x - 1][po.y] == 1 && !visited[po.x - 1][po.y]) {
                    visited[po.x - 1][po.y] = true;
                    que.offer(new Path(p, 1));
                }

                if (po.y < 5 && field[po.x][po.y + 1] == 1 && !visited[po.x][po.y + 1]) {
                    visited[po.x][po.y + 1] = true;
                    que.offer(new Path(p, 2));
                }

                if (po.x < 5 && field[po.x + 1][po.y] == 1 && !visited[po.x + 1][po.y]) {
                    visited[po.x + 1][po.y] = true;
                    que.offer(new Path(p, 3));
                }

                if (po.y > 0 && field[po.x][po.y - 1] == 1 && !visited[po.x][po.y - 1]) {
                    visited[po.x][po.y - 1] = true;
                    que.offer(new Path(p, 4));
                }
            }

            for (int p : path.log) {
                if (p == 1) {
                    rotateUp();
                } else if (p == 2) {
                    rotateRight();
                } else if (p == 3) {
                    rotateDown();
                } else if (p == 4) {
                    rotateLeft();
                }
            }

            now = to;
            chk();
        }
        public boolean isCube() {
            return chk;
        }

        private class Path {
            Point idx;
            int[] log; // 1: 위, 2: 오른쪽, 3: 아래, 4: 왼쪽

            public Path(Point p) {
                idx = p;
            }
            public Path(Path p, int direction) {
                Point next = null;
                if (direction == 1) {
                    next = new Point(p.idx.x - 1, p.idx.y);
                } else if (direction == 2) {
                    next = new Point(p.idx.x, p.idx.y + 1);
                } else if (direction == 3) {
                    next = new Point(p.idx.x + 1, p.idx.y);
                } else if (direction == 4) {
                    next = new Point(p.idx.x, p.idx.y - 1);
                }

                idx = next;

                if (p.log != null) {
                    log = new int[p.log.length + 1];
                    System.arraycopy(p.log, 0, log, 0, p.log.length);
                } else {
                    log = new int[1];
                }
                log[log.length - 1] = direction;
            }

            public boolean isReach(Point p) {
                if (idx.x == p.x) {
                    if (idx.y == p.y) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
