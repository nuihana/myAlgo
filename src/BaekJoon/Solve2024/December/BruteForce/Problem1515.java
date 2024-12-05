package BaekJoon.Solve2024.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1515 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int n = 0;
        int idx = 0;
        while (n++ <= 30000) {
            String tmp = String.valueOf(n);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == src.charAt(idx)) {
                    idx++;
                }

                if (idx == src.length()) {
                    System.out.print(n);
                    return;
                }
            }
        }

        br.close();
    }
}
