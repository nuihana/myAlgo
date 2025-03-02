package BaekJoon.Solve2025.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10984 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int tot = 0;
            float sum = 0.0f;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(st.nextToken());
                float g = Float.parseFloat(st.nextToken());

                tot += c;
                sum += g * c;
            }

            sb.append(tot).append(" ").append(String.format("%.1f", sum / tot)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
