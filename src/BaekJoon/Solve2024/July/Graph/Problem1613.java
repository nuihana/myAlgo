package BaekJoon.Solve2024.July.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1613 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int max = 50001;

        int[][] cost = new int[node + 1][node + 1];
        for (int i = 1; i <= node; i++) {
            Arrays.fill(cost[i], max);
            cost[i][i] = 0;
        }
        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[a][b] = 1;
        }

        for (int k = 1; k <= node; k++) {
            for (int i = 1; i <= node; i++) {
                for (int j = 1; j <= node; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        int query = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cost[a][b] > 0 && cost[a][b] < max) {
                sb.append("-1");
            } else if (cost[b][a] > 0 && cost[b][a] < max) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
