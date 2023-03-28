package BaekJoon.Solve2023.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem18111 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int blocks = Integer.parseInt(st.nextToken());
        int[][] field = new int[width][height];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int cost = Integer.MAX_VALUE;
        int layer = 0;
        for (int purpose = 0; purpose < 257; purpose++) {
            int tmp = 0;
            int tmpBlocks = blocks;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[j][i] > purpose) {
                        tmp += Math.abs(field[j][i] - purpose) * 2;
                        tmpBlocks += Math.abs(field[j][i] - purpose);
                    } else if (field[j][i] < purpose) {
                        tmp += Math.abs(field[j][i] - purpose);
                        tmpBlocks -= Math.abs(field[j][i] - purpose);
                    }
                }
            }
            if (tmpBlocks >= 0) {
                cost = Math.min(cost, tmp);
                if (cost == tmp) {
                    layer = purpose;
                }
            }
        }
        bw.write(cost + " " + layer);

        br.close();
        bw.close();
    }
}
