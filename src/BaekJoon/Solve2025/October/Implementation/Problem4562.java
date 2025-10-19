package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4562 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int eat = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            if (eat < need) {
                sb.append("NO BRAINS").append("\n");
            } else {
                sb.append("MMM BRAINS").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
