package BaekJoon.Solve2025.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6131 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 1; i <= 500; i++) {
            int val = i * i + n;

            boolean isOk = false;
            for (int j = 1; j <= val; j++) {
                if (j * j == val) {
                    isOk = true;
                    break;
                }
            }

            if (isOk) res++;
        }
        System.out.print(res);

        br.close();
    }
}
