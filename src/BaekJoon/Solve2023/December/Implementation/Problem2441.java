package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2441 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >0; i--) {
            sb.append(" ".repeat(Math.max(0, n - i)));
            sb.append("*".repeat(i));
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
