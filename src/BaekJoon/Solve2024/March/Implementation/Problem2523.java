package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2523 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            sb.append("*".repeat(i));
        }
        sb.append("*".repeat(n));
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i));
        }

        System.out.print(sb);

        br.close();
    }
}
