package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1673 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if (src == null || src.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(src);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int res = n;
            while (n >= k) {
                int plus = n / k;
                res += plus;
                n -= plus * k - plus;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
