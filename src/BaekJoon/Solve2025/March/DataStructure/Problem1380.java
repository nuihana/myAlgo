package BaekJoon.Solve2025.March.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1380 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int cNum = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            List<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                names.add(br.readLine());
            }

            boolean[] isReturned = new boolean[n + 1];
            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                String type = st.nextToken();

                isReturned[idx] = !isReturned[idx];
            }

            for (int i = 1; i <= n; i++) {
                if (isReturned[i]) {
                    sb.append(cNum++).append(" ").append(names.get(i - 1)).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);

        br.close();
    }
}
