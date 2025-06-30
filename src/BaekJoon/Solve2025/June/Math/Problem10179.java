package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10179 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            double val = Double.parseDouble(br.readLine());

            sb.append("$").append(String.format("%.2f", val * 0.8)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
