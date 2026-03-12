package BaekJoon.Solve2026.March.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 2; i + j < n; j++) {
                int k = n - i - j;
                if (k > 0 && k % 2 == 0) res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
