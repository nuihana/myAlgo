package BaekJoon.Solve2024.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6550 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);
            String org = st.nextToken();
            String cpr = st.nextToken();

            if (isContain(org, cpr)) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isContain(String org, String cpr) {
        int idx = 0;
        for (int i = 0; i < cpr.length() && idx < org.length(); i++) {
            char cc = cpr.charAt(i);
            if (cc == org.charAt(idx)) {
                idx++;
            }
        }
        return idx == org.length();
    }
}
