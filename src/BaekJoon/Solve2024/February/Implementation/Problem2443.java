package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2443 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >0; i--) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2 * i - 1));
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
