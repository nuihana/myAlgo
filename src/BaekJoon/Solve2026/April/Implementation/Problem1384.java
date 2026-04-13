package BaekJoon.Solve2026.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1384 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            sb.append("Group ").append(idx++).append("\n");

            String[] names = new String[n];
            char[][] messages = new char[n][n - 1];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                names[i] = st.nextToken();
                for (int j = 0; j < n - 1; j++) {
                    messages[i][j] = st.nextToken().charAt(0);
                }
            }

            boolean isClean = true;
            for (int i = 0; i < n; i++) {
                String rec = names[i];
                for (int j = 0; j < n - 1; j++) {
                    if (messages[i][j] == 'N') {
                        isClean = false;
                        String send = names[(i + n - j - 1) % n];
                        sb.append(send).append(" was nasty about ").append(rec).append("\n");
                    }
                }
            }

            if (isClean) sb.append("Nobody was nasty").append("\n");
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
