package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10992 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int ot = n - 1;
        int it = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                sb.append("*".repeat(n * 2 - 1));
            } else {
                sb.append(" ".repeat(ot))
                        .append("*");
                if (it > 0) {
                    sb.append(" ".repeat(it * 2 - 1))
                            .append("*");
                }
                it++;
                ot--;
                sb.append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
