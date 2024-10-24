package BaekJoon.Solve2024.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem9536 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String whole = br.readLine();

            Set<String> other = new HashSet<>();

            while (true) {
                String info = br.readLine();
                if (info.equals("what does the fox say?")) {
                    break;
                }

                StringTokenizer st = new StringTokenizer(info);
                st.nextToken();
                st.nextToken();

                other.add(st.nextToken());
            }

            StringTokenizer st = new StringTokenizer(whole);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (!other.contains(token)) {
                    sb.append(token).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
