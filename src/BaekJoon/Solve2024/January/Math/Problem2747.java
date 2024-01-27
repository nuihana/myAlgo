package BaekJoon.Solve2024.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2747 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] pbnc = new int[46];
        pbnc[1] = 1;
        for (int i = 2; i < 46; i++) {
            pbnc[i] = pbnc[i - 1] + pbnc[i - 2];
        }

        System.out.print(pbnc[n]);

        br.close();
    }
}
