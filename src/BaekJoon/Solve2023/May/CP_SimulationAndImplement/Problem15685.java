package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15685 {
    int[][] filed;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int dragonCnt = Integer.parseInt(br.readLine());
        filed = new int[101][101];

        DragonCurve[] dragonArr = new DragonCurve[dragonCnt];
        for (int i = 0; i < dragonCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dragonArr[i] = new DragonCurve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
                                            , Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (DragonCurve dc : dragonArr) {
            dc.draw();
        }

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                System.out.print(filed[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
        bw.close();
    }

    class DragonCurve {
        int x;
        int y;
        int direction; // 0: 동, 1: 북, 2: 서, 3: 남
        int level;

        private List<int[]> pathList;

        public DragonCurve(int x_, int y_, int direction_, int level_) {
            this.x = x_;
            this.y = y_;
            this.direction = direction_;
            this.level = level_;

            filed[x][y] = 1;
            if (direction == 0) {
                y += 1;
            } else if (direction == 1) {
                x -= 1;
            } else if (direction == 2) {
                y -= 1;
            } else if (direction == 3) {
                x += 1;
            }
            filed[x][y] = 1;

            pathList = new ArrayList<>();
            int[] tmp = new int[2];
            tmp[1] = 1;
            pathList.add(tmp);
        }

        private void draw() {
            direction = (direction - 1) % 4; // 시계방향 90도 회전
            List<int[]> nextList = new ArrayList<>();

            for (int i = 0; i < pathList.size(); i++) {
                int[] tmp = pathList.get(i);
                int[] next = new int[2];

                if (direction == 0) {
                    next[0] = tmp[0];
                    next[1] = tmp[1];

                    x += next[0];
                    y += next[1];
                } else if (direction == 1) {
                    next[0] = tmp[1] * - 1;
                    next[1] = tmp[0];

                    x += next[0];
                    y += next[1];
                } else if (direction == 2) {
                    next[0] = tmp[0] * - 1;
                    next[1] = tmp[1] * - 1;

                    x += next[0];
                    y += next[1];
                } else if (direction == 3) {
                    next[0] = tmp[1];
                    next[1] = tmp[0] * - 1;

                    x += next[0];
                    y += next[1];
                }

                filed[x][y] = 1;
                nextList.add(next);
            }

            pathList.addAll(nextList);
        }

        public void setDragon() {
            int now = 1;
            while (now <= level) {
                draw();

                now++;
            }
        }
    }
}
