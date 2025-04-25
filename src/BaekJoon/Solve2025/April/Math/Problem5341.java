package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5341 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int res = 0;
            for (int i = 1; i <= n; i++) {
                res += i;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
