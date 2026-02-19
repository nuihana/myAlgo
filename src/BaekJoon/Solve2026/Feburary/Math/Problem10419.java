package BaekJoon.Solve2026.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10419 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int d = Integer.parseInt(br.readLine());

            int res = 0;
            while (res + res * res <= d) {
                res++;
            }

            sb.append(res - 1).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
