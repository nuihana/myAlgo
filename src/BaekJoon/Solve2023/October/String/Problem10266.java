package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10266 {
    final int CLOCK_SIZE = 360000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] clockA = new int[CLOCK_SIZE * 2];
        int[] clockB = new int[CLOCK_SIZE];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            clockA[num] = 1;
            clockA[num + CLOCK_SIZE] = 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            clockB[num] = 1;
        }

        int[] table = makeTable(clockB);
        int idx = 0;
        for (int i = 0; i < CLOCK_SIZE * 2; i++) {
            while (idx > 0 && clockA[i] != clockB[idx]) {
                idx = table[idx - 1];
            }

            if (clockA[i] == clockB[idx]) {
                if (idx == CLOCK_SIZE - 1) {
                    bw.write("possible");
                    bw.close();
                    return;
                }
                idx++;
            }
        }

        bw.write("impossible");

        br.close();
        bw.close();
    }

    private int[] makeTable(int[] clock) {
        int idx = 0;
        int[] table = new int[CLOCK_SIZE];
        for (int i = 1; i < CLOCK_SIZE; i++) {
            while (idx > 0 && clock[i] != clock[idx]) {
                idx = table[idx - 1];
            }

            if (clock[i] == clock[idx]) {
                table[i] = ++idx;
            }
        }
        return table;
    }
}
