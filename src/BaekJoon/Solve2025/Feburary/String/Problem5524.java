package BaekJoon.Solve2025.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5524 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String src = br.readLine();
            sb.append(src.toLowerCase()).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
