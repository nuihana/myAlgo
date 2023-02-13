package BaekJoon.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2630 {
    int[][] valArr;
    int white = 0;
    int blue = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int paperSize = Integer.parseInt(br.readLine());
        valArr = new int[paperSize][paperSize];

        for (int i = 0; i < paperSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paperSize; j++) {
                valArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        daq(0, 0, paperSize);

        bw.write(white + "\n" + blue);

        br.close();
        bw.close();
    }

    private void daq(int x, int y, int size) {
        int isSolid = isSolid(x, y, size);
        if (isSolid >= 0) {
            if (isSolid == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int divSize = size / 2;
        daq(x, y, divSize);
        daq(x + divSize, y, divSize);
        daq(x, y + divSize, divSize);
        daq(x + divSize, y + divSize, divSize);
    }

    private int isSolid(int x, int y, int size) {
        int color = valArr[x][y];
        boolean result = true;

        for (int i = x, iLimit = x + size; i < iLimit; i++) {
            if (result) {
                for (int j = y, jLimit = y + size; j < jLimit; j++) {
                    if (valArr[i][j] != color) {
                        result = false;
                        break;
                    }
                }
            }
        }

        if (result) {
            return color;
        } else {
            return -1;
        }
    }
}
