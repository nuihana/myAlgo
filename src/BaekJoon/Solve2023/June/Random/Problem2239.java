package BaekJoon.Solve2023.June.Random;

import java.io.*;

public class Problem2239 {
    int[][] sdoku;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sdoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        solve(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(sdoku[i][j]));
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private boolean solve(int pos) {
        if (pos == 81) return true;

        int x = pos / 9;
        int y = pos % 9;

        if (sdoku[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!chk(x, y, i)) continue;

                sdoku[x][y] = i;
                if (solve(pos + 1)) return true;
                sdoku[x][y] = 0;
            }
        } else {
            return solve(pos + 1);
        }

        return false;
    }

    private boolean chk(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (sdoku[x][i] == val) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (sdoku[i][y] == val) return false;
        }

        int section_x = x / 3;
        int section_y = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sdoku[section_x * 3 + i][section_y * 3 + j] == val) return false;
            }
        }

        return true;
    }
}
