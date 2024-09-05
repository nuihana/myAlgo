package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13015 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int interval = n - 2;
        sb.append("*".repeat(n)).append(" ".repeat(interval * 2 + 1)).append("*".repeat(n)).append("\n");
        for (int i = 0; i < interval; i++) {
            sb.append(" ".repeat(i + 1)).append("*").append(" ".repeat(interval)).append("*")
                    .append(" ".repeat((interval - i) * 2 - 1)).append("*").append(" ".repeat(interval)).append("*").append("\n");
        }
        sb.append(" ".repeat(n - 1)).append("*").append(" ".repeat(interval)).append("*").append(" ".repeat(interval)).append("*").append("\n");
        for (int i = 0; i < interval; i++) {
            sb.append(" ".repeat(interval - i)).append("*").append(" ".repeat(interval)).append("*")
                    .append(" ".repeat(i * 2 + 1)).append("*").append(" ".repeat(interval)).append("*").append("\n");
        }
        sb.append("*".repeat(n)).append(" ".repeat(interval * 2 + 1)).append("*".repeat(n)).append("\n");
        System.out.print(sb);

        br.close();
    }
}
