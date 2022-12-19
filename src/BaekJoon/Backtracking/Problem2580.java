package BaekJoon.Backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2580 {
    private int[][] result = new int[9][9];
    private StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setResult(0, 0);

        br.close();
    }

    private void setResult(int row, int col) {
        if (col == 9) {
            setResult(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(result[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        if (result[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possible(row, col, i)) {
                    result[row][col] = i;
                    setResult(row, col + 1);
                }
            }
            result[row][col] = 0;
            return;
        }

        setResult(row, col + 1);
    }

    private boolean possible(int row, int col, int val) {
        //가로 chk
        for (int i = 0; i < 9; i++) {
            if (result[row][i] == val) {
                return false;
            }
        }

        //세로 chk
        for (int i = 0; i < 9; i++) {
            if (result[i][col] == val) {
                return false;
            }
        }

        //3x3 구역 set
        int areaX = (row / 3) * 3;
        int areaY = (col / 3) * 3;

        for (int i = areaX, iLimit = i + 3; i < iLimit; i++) {
            for (int j = areaY, jLimit = j + 3; j < jLimit; j++) {
                if (result[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
