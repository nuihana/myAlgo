package BaekJoon.Solve2022.DynamicPlanning;

import java.io.*;

public class Problem9461 {
    long[] valArr = new long[100];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        valArr[0] = 1;
        valArr[1] = 1;
        valArr[2] = 1;

        for (int i = 0; i < input; i++) {
            int idx = Integer.parseInt(br.readLine());

            bw.write(wave(idx) + "\n");
        }

        br.close();
        bw.close();
    }

    private long wave(int value) {
        if (valArr[value - 1] > 0) {
            return valArr[value - 1];
        }

        return valArr[value - 1] = (wave(value - 4) + wave(value - 3));
    }
}
