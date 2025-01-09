package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10995 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sb.append(" ");
            }

            for (int j = 0; j < i; j++) {
                sb.append("*").append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
