package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5354 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) {
                    sb.append("#".repeat(n));
                } else {
                    sb.append("#").append("J".repeat(n - 2)).append("#");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
