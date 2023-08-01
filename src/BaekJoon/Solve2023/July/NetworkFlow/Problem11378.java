package BaekJoon.Solve2023.July.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem11378 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int source = 0;
        int sink = n + m + 1;
        int bridge = sink + 1;
        int len = bridge + 1;

        List<Integer>[] edge = new ArrayList[len];
        for (int i = 0; i < len; i++) edge[i] = new ArrayList<>();

        int[][] capacity = new int[len][len], flow = new int[len][len];
        // n > m
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int idx = Integer.parseInt(st.nextToken());

                edge[i].add(idx + n);
                edge[idx + n].add(i);
                capacity[i][idx + n] = 1;
            }
        }

        //source > bridge
        capacity[source][bridge] = k;
        edge[source].add(bridge);
        edge[bridge].add(source);

        //source > n, bridge > n
        for (int i = 1; i <= n; i++) {
            capacity[source][i] = 1;
            edge[source].add(i);
            edge[i].add(source);

            capacity[bridge][i] = k;
            edge[bridge].add(i);
            edge[i].add(bridge);
        }

        //m > sink
        for (int i = n + 1; i <= n + m; i++) {
            capacity[i][sink] = 1;
            edge[i].add(sink);
            edge[sink].add(i);
        }

        int totalFlow = 0;
        while(true) {
            int[] parent = new int[len];
            Arrays.fill(parent, -1);

            Queue<Integer> que = new LinkedList<>();
            que.offer(source);
            parent[source] = source;

            while(!que.isEmpty() && parent[sink] == -1) {
                int now = que.poll();
                for (int next : edge[now]) {
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

            totalFlow += minFlow;
        }

        bw.write(String.valueOf(totalFlow));

        br.close();
        bw.close();
    }
}
