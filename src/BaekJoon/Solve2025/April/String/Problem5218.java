package BaekJoon.Solve2025.April.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5218 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            sb.append("Distances: ");
            for (int i = 0; i < a.length(); i++) {
                int ac = a.charAt(i);
                int bc = b.charAt(i);

                if (ac > bc) {
                    sb.append(bc + 26 - ac).append(" ");
                } else {
                    sb.append(bc - ac).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
