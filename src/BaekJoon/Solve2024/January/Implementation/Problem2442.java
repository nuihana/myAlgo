package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2442 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                sb.append(" ");
            }

            for (int k = 1; k < i; k++) {
                sb.append("*");
            }
            sb.append("*");

            for (int k = 1; k < i; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
