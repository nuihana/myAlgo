package BaekJoon.Solve2025.October.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5671 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if (src == null || src.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(src);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = n; i <= m; i++) {
                boolean[] isUsed = new boolean[10];

                int tmp = i;
                boolean isUnique = true;
                while (tmp > 0) {
                    if (isUsed[tmp % 10]) {
                        isUnique = false;
                        break;
                    }
                    isUsed[tmp % 10] = true;
                    tmp /= 10;
                }

                if (isUnique) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
