package BaekJoon.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10830 {
    int[][] matrix;
    Integer[][] result;
    int size;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        matrix = new int[size][size];
        result = new Integer[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Integer[] binaryB = new Integer[64];
        int maximumB = 0;

        for (int i = 0; b != 1; i++) {
            binaryB[i] = (int) (b % 2);
            b = b / 2;
            maximumB = i + 1;
        }
        binaryB[maximumB] = 1;

        for (int i = 0; binaryB[i] != null; i++) {
            if(binaryB[i] > 0) {
                sqrResult();
            }
            sqrMatrix();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private void sqrResult() {
        int[][] tmpMatrix = new int[size][size];
        if (result[0][0] != null) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int tmp = 0;
                    for (int l = 0; l < size; l++) {
                        tmp += (result[i][l] * matrix[l][j]) % 1000;
                    }
                    tmpMatrix[i][j] = tmp % 1000;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    tmpMatrix[i][j] = matrix[i][j] % 1000;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = tmpMatrix[i][j];
            }
        }
    }

    private void sqrMatrix() {
        int[][] tmpMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tmp = 0;
                for (int l = 0; l < size; l++) {
                    tmp += (matrix[i][l] * matrix[l][j]) % 1000;
                }
                tmpMatrix[i][j] = tmp % 1000;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = tmpMatrix[i][j];
            }
        }
    }
}
