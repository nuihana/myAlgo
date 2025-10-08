package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20053 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
