package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2522 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(n - i)).append("*".repeat(i)).append("\n");
        }
        sb.append("*".repeat(n)).append("\n");
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(i)).append("*".repeat(n - i)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
