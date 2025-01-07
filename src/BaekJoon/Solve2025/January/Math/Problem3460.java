package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3460 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    sb.append(idx).append(" ");
                }
                n /= 2;
                idx++;
            }
        }
        System.out.print(sb);

        br.close();
    }
}
