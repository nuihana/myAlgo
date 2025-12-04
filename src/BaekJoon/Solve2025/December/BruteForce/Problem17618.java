package BaekJoon.Solve2025.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17618 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0, val = i;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
            if (i % sum == 0) res++;
        }
        System.out.print(res);

        br.close();
    }
}
