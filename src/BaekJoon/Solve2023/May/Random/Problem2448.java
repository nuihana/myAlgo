package BaekJoon.Solve2023.May.Random;

import java.io.*;

public class Problem2448 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int value = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[value][value * 2 - 1];

        for (int i = 0; i < 5; i++) {
            paper[value - 1][i] = true;
        }
        paper[value - 2][1] = true;
        paper[value - 2][3] = true;
        paper[value - 3][2] = true;

        int size = 3;
        int idx = 1;
        while (size * Math.pow(2, idx) <= value) {
            int x = value - 1;
            int y = (int) (size * Math.pow(2, idx));
            for (int i = 0; i < 3 * Math.pow(2, idx - 1); i++) {
                for (int j = 0; j < size * Math.pow(2, idx) - 1; j++) {
                    paper[x - i][y + j] = paper[value - 1 - i][j];
                }
            }

            x = value - (int) (size * Math.pow(2, idx - 1)) - 1;
            y = (int) (size * Math.pow(2, idx - 1));
            for (int i = 0; i < 3 * Math.pow(2, idx - 1); i++) {
                for (int j = 0; j < size * Math.pow(2, idx) - 1; j++) {
                    paper[x - i][y + j] = paper[value - 1 - i][j];
                }
            }

            idx++;
        }

        for (int i = 0; i < value; i++) {
            for (int j = 0; j < paper[i].length; j++) {
                if (paper[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
