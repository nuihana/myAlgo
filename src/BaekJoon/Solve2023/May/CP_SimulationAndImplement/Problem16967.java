package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16967 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int dh = Integer.parseInt(st.nextToken());
        int dw = Integer.parseInt(st.nextToken());

        int[][] before = new int[height + dh][width + dw];
        for (int i = 0; i < height + dh; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width + dw; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] after = new int[height][width];
        for (int i = 0; i < height; i++) {
            if (i < dh) {
                for (int j =0; j < width; j++) {
                    after[i][j] = before[i][j];
                }
            } else {
                for (int j =0; j < width; j++) {
                    if (j < dw) {
                        after[i][j] = before[i][j];
                    } else {
                        after[i][j] = before[i][j] - after[i - dh][j - dw];
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bw.write(after[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
