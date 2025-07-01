package BaekJoon.Solve2025.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5054 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stores = new int[n];
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                stores[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, stores[i]);
                min = Math.min(min, stores[i]);
            }

            int res = (max - min) * 2;
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
