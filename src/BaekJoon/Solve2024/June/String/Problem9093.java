package BaekJoon.Solve2024.June.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9093 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (caseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String piece = st.nextToken();

                for (int i = 0; i < piece.length(); i++) {
                    sb.append(piece.charAt(piece.length() - 1 - i));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
