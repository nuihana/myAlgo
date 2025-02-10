package BaekJoon.Solve2025.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2711 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nth = Integer.parseInt(st.nextToken());
            String src = st.nextToken();

            for (int i = 0; i < src.length(); i++) {
                if (i == nth - 1) continue;
                sb.append(src.charAt(i));
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
