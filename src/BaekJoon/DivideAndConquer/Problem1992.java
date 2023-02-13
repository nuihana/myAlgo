package BaekJoon.DivideAndConquer;

import java.io.*;

public class Problem1992 {
    int[][] valArr;
    StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int paperSize = Integer.parseInt(br.readLine());
        valArr = new int[paperSize][paperSize];

        for (int i = 0; i < paperSize; i++) {
            String line = br.readLine();
            for (int j = 0; j < paperSize; j++) {
                valArr[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        sb.append("(");
        daq(0, 0, paperSize);
        sb.append(")");

        System.out.print(sb.toString());

        br.close();
    }

    private void daq(int x, int y, int size) {
        int isSolid = isSolid(x, y, size);
        if (isSolid >= 0) {
            sb.append(isSolid);
            return;
        }
        sb.append("(");

        int divSize = size / 2;
        daq(x, y, divSize);
        daq(x, y + divSize, divSize);
        daq(x + divSize, y, divSize);
        daq(x + divSize, y + divSize, divSize);
        sb.append(")");
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
