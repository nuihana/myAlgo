package BaekJoon.Solve2025.December.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9550 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int res = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int now = Integer.parseInt(st.nextToken());
                res += now / k;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
