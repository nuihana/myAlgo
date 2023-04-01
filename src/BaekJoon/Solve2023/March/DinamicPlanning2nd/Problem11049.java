package BaekJoon.Solve2023.March.DinamicPlanning2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11049 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int matrixCnt = Integer.parseInt(br.readLine());
        int[][] dp = new int[matrixCnt][matrixCnt];
        Matrix[][] matrixArr = new Matrix[matrixCnt][matrixCnt];

        for (int i = 0; i < matrixCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            matrixArr[i][i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < matrixCnt; i++) {
            for(int j = 0, jLimit = matrixCnt - i; j < jLimit; j++) {
                if (i == 1) {
                    dp[j][i + j] = matrixArr[j][j].getMultiple(matrixArr[i + j][i + j]);
                    matrixArr[j][i + j] = new Matrix(matrixArr[j][j].getX(), matrixArr[i + j][i + j].getY());
                } else {
                    int tmpSum = Integer.MAX_VALUE;
                    Matrix tmpMatrix = null;
                    for(int k = j, kLimit = i + j; k < kLimit; k++) {
                        int tmp = tmpSum;
                        tmpSum = Math.min(tmpSum, matrixArr[j][k].getMultiple(matrixArr[k + 1][kLimit]) + dp[j][k] + dp[k + 1][kLimit]);

                        if (tmp != tmpSum) {
                            tmpMatrix = new Matrix(matrixArr[j][k].getX(), matrixArr[k + 1][kLimit].getY());
                        }
                    }
                    dp[j][i + j] = tmpSum;
                    matrixArr[j][i + j] = tmpMatrix;
                }
            }
        }

        System.out.print(dp[0][matrixCnt - 1]);

        br.close();
    }
}

class Matrix {
    private int x;
    private int y;

    public Matrix(int inputX, int inputY) {
        this.x = inputX;
        this.y = inputY;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int getMultiple(Matrix another) {
        return this.x * this.y * another.getY();
    }
}