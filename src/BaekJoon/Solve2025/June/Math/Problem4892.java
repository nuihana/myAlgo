package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4892 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            int n0 = Integer.parseInt(br.readLine());
            if (n0 == 0) break;

            int n1 = n0 * 3;
            sb.append(idx++).append(". ");
            if (n1 % 2 == 1) {
                sb.append("odd ");
                n1++;
            } else {
                sb.append("even ");
            }

            int n2 = n1 / 2;
            int n3 = n2 * 3;
            int n4 = n3 / 9;
            sb.append(n4).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
