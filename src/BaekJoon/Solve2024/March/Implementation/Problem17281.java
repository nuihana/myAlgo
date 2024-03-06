package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17281 {
    int inning;
    int[][] record;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inning = Integer.parseInt(br.readLine());
        record = new int[inning][9];
        for (int i = 0; i < inning; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                record[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] order = new int[8];
        boolean[] isIncluded = new boolean[9];
        isIncluded[0] = true;
        System.out.print(simulate(order, isIncluded, 0));

        br.close();
    }

    private int simulate(int[] ord, boolean[] isIn, int idx) {
        if (idx == 8) {
            return calculate(ord);
        }

        int res = 0;
        for (int i = 0; i < 9; i++) {
            if (!isIn[i]) {
                isIn[i] = true;
                ord[idx] = i;
                res = Math.max(res, simulate(ord, isIn, idx + 1));
                isIn[i] = false;
            }
        }
        return res;
    }

    private int calculate(int[] ord) {
        int[] order = new int[9];
        System.arraycopy(ord, 0, order, 0, 3);
        order[3] = 0;
        System.arraycopy(ord, 3, order, 4, 5);

        int score = 0, turn = 0, out = 0, teamOrd = 0;
        while (turn < inning) {
            while (out < 3) {
                int[] ru = new int[3];
                if (record[turn][order[teamOrd]] == 0) {
                    out++;
                } else if (record[turn][order[teamOrd]] == 1) { // 안타
                    if (ru[2] > 0) {
                        ru[2] = 0;
                        score++;
                    }
                    if (ru[1] > 0) {
                        ru[2] = 1;
                        ru[1] = 0;
                    }
                    if (ru[0] > 0) {
                        ru[1] = 1;
                        ru[0] = 0;
                    }
                    ru[0] = 1;
                } else if (record[turn][order[teamOrd]] == 2) { // 2루타
                    if (ru[2] > 0) {
                        ru[2] = 0;
                        score++;
                    }
                    if (ru[1] > 0) {
                        ru[1] = 0;
                        score++;
                    }
                    if (ru[0] > 0) {
                        ru[2] = 1;
                        ru[0] = 0;
                    }
                    ru[1] = 1;
                } else if (record[turn][order[teamOrd]] == 3) { // 3루타
                    for (int i = 0; i < 3; i++) {
                        if (ru[i] > 0) score++;
                    }
                    Arrays.fill(ru, 0);
                    ru[2] = 1;
                } else if (record[turn][order[teamOrd]] == 4) { // 홈런
                    for (int i = 0; i < 3; i++) {
                        if (ru[i] > 0) score++;
                    }
                    Arrays.fill(ru, 0);
                    score++;
                }
                teamOrd = (teamOrd + 1) % 9;
            }
            out = 0;
            turn++;
        }

        return score;
    }
}
