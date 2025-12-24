package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4766 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float init = Float.parseFloat(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if ("999".equals(src)) break;

            float next = Float.parseFloat(src);
            sb.append(String.format("%.2f", next - init)).append("\n");
            init = next;
        }
        System.out.print(sb);

        br.close();
    }
}
