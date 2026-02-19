package BaekJoon.Solve2026.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2003 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        while (n > Math.pow(10, idx)) {
            int l = (int) Math.pow(10, idx);
            int m = l / 10;

            int p = n % l / m;
            n -= p * m;
            if (p >= 5) {
                n += l;
            }
            idx++;
        }

        br.close();
    }
}
