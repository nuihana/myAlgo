package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11098 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int cnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.parseInt(st.nextToken());
            String player = st.nextToken();

            for (int i = 0; i < cnt - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int cost = Integer.parseInt(st.nextToken());
                if (max < cost) {
                    max = cost;
                    player = st.nextToken();
                }
            }

            sb.append(player).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
