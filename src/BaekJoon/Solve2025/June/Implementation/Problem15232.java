package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15232 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append("*".repeat(Math.max(0, c)));
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
