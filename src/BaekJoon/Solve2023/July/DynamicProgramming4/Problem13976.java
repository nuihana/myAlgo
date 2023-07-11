package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;

public class Problem13976 {
    final static int MOD = 1000000007;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long num = Long.parseLong(br.readLine());

        if (num % 2 > 0) {
            bw.write("0");
        } else {
            long[][] base = {{0, 1}, {-1, 4}};
            long[][] answer = {{1, 0}, {3, 0}};

            base = matrixPowerMod(base, num / 2);
            answer = matrixMultiplyMod(base, answer);

            bw.write(String.valueOf(answer[0][0]));
        }

        br.close();
        bw.close();
    }

    private long[][] matrixMultiplyMod (long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    long tmp = (A[i][k] * B[k][j] + MOD) % MOD;
                    result[i][j] = (result[i][j] + tmp) % MOD;
                }
            }
        }
        return result;
    }

    private long[][] matrixPowerMod(long[][] base, long pow) {
        long[][] result = {{1, 0}, {0, 1}};
        while (pow > 0) {
            if (pow % 2 > 0) result = matrixMultiplyMod(result, base);
            base = matrixMultiplyMod(base, base);
            pow /= 2;
        }
        return result;
    }
}
