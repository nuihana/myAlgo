package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3034 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double max = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            if (max >= len) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
