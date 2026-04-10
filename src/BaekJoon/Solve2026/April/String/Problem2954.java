package BaekJoon.Solve2026.April.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2954 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String src = st.nextToken();

            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') i += 2;

                sb.append(c);
            }
            sb.append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
