package BaekJoon.Solve2025.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2386 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;
            StringTokenizer st = new StringTokenizer(s);

            char ch = st.nextToken().charAt(0);
            int res = 0;
            while (st.hasMoreTokens()) {
                String src = st.nextToken().toLowerCase();
                for (char c : src.toCharArray()) {
                    if (ch == c) res++;
                }
            }

            sb.append(ch).append(" ").append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
