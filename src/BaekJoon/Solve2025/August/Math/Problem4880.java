package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4880 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) break;

            int diff = b - a;
            int mult = a != 0 ? b / a : -1;

            if (c - b == diff) {
                sb.append("AP").append(" ").append(c + diff).append("\n");
            } else if (c / b == mult) {
                sb.append("GP").append(" ").append(c * mult).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
