package BaekJoon.Solve2023.August.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem2316 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int v = (n + 1) * 2;
        int[][] capacity = new int[v][v], flow = new int[v][v];

        for (int i = 2; i < v; i += 2) {
            capacity[i][i + 1] = 1;
        }

        final int INF = 100000;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int a_in = a * 2;
            int a_out = a_in + 1;
            int b_in = b * 2;
            int b_out = b_in + 1;

            capacity[a_out][b_in] = INF;
            capacity[b_out][a_in] = INF;
        }

        int source = 3, sink = 4;
        int maxFlow = 0;
        while (true) {
            int[] parent = new int[v];
            Arrays.fill(parent, -1);

            Queue<Integer> que = new LinkedList<>();
            que.offer(source);
            parent[source] = source;

            while (!que.isEmpty() && parent[sink] == -1) {
                int now = que.poll();
                for (int next = 2; next < v; next++) {
                    if (parent[next] == -1 && capacity[now][next] - flow[now][next] > 0) {
                        que.offer(next);
                        parent[next] = now;
                    }
                }
            }

            if (parent[sink] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for (int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            maxFlow += minFlow;
        }

        bw.write(String.valueOf(maxFlow));

        br.close();
        bw.close();
    }
}
