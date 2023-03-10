package BaekJoon.Solve2023.DivisorMultiplePrimeNumQuick;

import java.io.*;

public class Problem4134 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            long num = Long.parseLong(br.readLine());

            bw.write(String.valueOf(getCeilPrimeNum(num)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private long getCeilPrimeNum(long value) {
        while (true) {
            if (isPrimeNum(value)) {
                return value;
            }
            value++;
        }
    }
    private boolean isPrimeNum(long value) {
        if (value < 2) {
            return false;
        }

        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
