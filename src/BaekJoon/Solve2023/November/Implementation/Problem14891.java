package BaekJoon.Solve2023.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14891 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String gear1 = br.readLine();
        String gear2 = br.readLine();
        String gear3 = br.readLine();
        String gear4 = br.readLine();

        Gears gears = new Gears(gear1, gear2, gear3, gear4);

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            if (idx == 1) gears.rotateA(direction, 0);
            if (idx == 2) gears.rotateB(direction, 0);
            if (idx == 3) gears.rotateC(direction, 0);
            if (idx == 4) gears.rotateD(direction, 0);
        }

        System.out.print(gears.score());

        br.close();
    }

    class Gears {
        Gear gearA;
        Gear gearB;
        Gear gearC;
        Gear gearD;

        public Gears(String src1, String src2, String src3, String src4) {
            gearA = new Gear(src1);
            gearB = new Gear(src2);
            gearC = new Gear(src3);
            gearD = new Gear(src4);
        }

        public void rotateA(int direction, int ord) { // ord 0 : 최초 회전, 전부 체크 / -1 : 왼쪽만 / 1 : 오른쪽만
            if (ord == 0 && gearA.stat[2] != gearB.stat[6]) {
                rotateB(-direction, 1);
            }
            gearA.rotate(direction);
        }

        public void rotateB(int direction, int ord) {
            if (ord <= 0 && gearA.stat[2] != gearB.stat[6]) {
                rotateA(-direction, -1);
            }
            if (ord >= 0 && gearB.stat[2] != gearC.stat[6]) {
                rotateC(-direction, 1);
            }
            gearB.rotate(direction);
        }

        public void rotateC(int direction, int ord) {
            if (ord <= 0 && gearB.stat[2] != gearC.stat[6]) {
                rotateB(-direction, -1);
            }
            if (ord >= 0 && gearC.stat[2] != gearD.stat[6]) {
                rotateD(-direction, 1);
            }
            gearC.rotate(direction);
        }

        public void rotateD(int direction, int ord) {
            if (ord == 0 && gearC.stat[2] != gearD.stat[6]) {
                rotateC(-direction, -1);
            }
            gearD.rotate(direction);
        }

        public int score() {
            int res = 0;
            if (gearA.stat[0] == 1) res += 1;
            if (gearB.stat[0] == 1) res += 2;
            if (gearC.stat[0] == 1) res += 4;
            if (gearD.stat[0] == 1) res += 8;
            return res;
        }

        private class Gear {
            int[] stat;

            public Gear(String src) {
                stat = new int[src.length()];
                for (int i = 0; i < src.length(); i++) {
                    stat[i] = Integer.parseInt(src.substring(i, i + 1));
                }
            }

            public void rotate(int direction) {
                int[] newStat = new int[stat.length];
                if (direction > 0) { // 시계
                    System.arraycopy(stat, 0, newStat, 1, 7);
                    newStat[0] = stat[7];
                } else { // 반시계
                    System.arraycopy(stat, 1, newStat, 0, 7);
                    newStat[7] = stat[0];
                }
                stat = newStat;
            }
        }
    }
}
