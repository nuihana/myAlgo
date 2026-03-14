package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4589 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("Gnomes:").append("\n");
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b) {
                if (b > c) {
                    sb.append("Ordered").append("\n");
                } else {
                    sb.append("Unordered").append("\n");
                }
            } else {
                if (b < c) {
                    sb.append("Ordered").append("\n");
                } else {
                    sb.append("Unordered").append("\n");
                }
            }
        }
        System.out.print(sb);

        br.close();
    }
}
