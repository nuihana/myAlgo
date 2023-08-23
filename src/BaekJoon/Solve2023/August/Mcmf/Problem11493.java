package BaekJoon.Solve2023.August.Mcmf;

import java.io.*;
import java.util.*;

public class Problem11493 {
    int n, m;
    int[][] route;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int inf = 987654321;
            int source = 0;
            int bias = 500;
            int sink = 1001;
            int len = sink + 1;

            int[][] capacity = new int[len][len];
            int[][] flow = new int[len][len];
            int[][] cost = new int[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(cost[i], 501);
            }
            route = new int[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(route[i], 501);
            }
            List<Integer>[] edges = new ArrayList[len];
            for (int i = 0; i < len; i++) edges[i] = new ArrayList<>();

            for (int i = 1; i <= n; i++) route[i][i] = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                route[a][b] = 1;
                route[b][a] = 1;
            }

            floyd();

            // source > black base
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                String isBlack = st.nextToken();

                if (isBlack.equals("1")) {
                    edges[i].add(source);
                    edges[source].add(i);

                    capacity[source][i] = 1;
                    cost[source][i] = 0;
                }
            }

            // black coin > sink
            st = new StringTokenizer(br.readLine());
            for (int i = 501; i <= n + bias; i++) {
                String isBlack = st.nextToken();

                if (isBlack.equals("1")) {
                    for (int before : edges[source]) {
                        edges[before].add(i);
                        edges[i].add(before);

                        capacity[before][i] = inf;
                        cost[before][i] = route[before][i - 500];
                        cost[i][before] = -cost[before][i];
                    }
                    edges[i].add(sink);
                    edges[sink].add(i);

                    capacity[i][sink] = 1;
                    cost[i][sink] = 0;
                }
            }

            int res = 0;
            while (true) {
                int[] parent = new int[len];
                Arrays.fill(parent, -1);
                int[] dist = new int[len];
                Arrays.fill(dist, inf);
                boolean[] inQ = new boolean[len];

                Queue<Integer> que = new LinkedList<>();
                que.add(source);
                inQ[source] = true;
                dist[source] = 0;

                while(!que.isEmpty()) {
                    int now = que.poll();
                    inQ[now] = false;

                    for (int next : edges[now]) {
                        if (dist[next] > dist[now] + cost[now][next]
                        && capacity[now][next] - flow[now][next] > 0) {
                            dist[next] = dist[now] + cost[now][next];
                            parent[next] = now;
                            if (!inQ[next]) {
                                que.offer(next);
                                inQ[next] = true;
                            }
                        }
                    }
                }

                if (parent[sink] == -1) break;
                int fl = Integer.MAX_VALUE;

                for (int i = sink; i != source; i = parent[i]) {
                    fl = Math.min(fl, capacity[parent[i]][i] - flow[parent[i]][i]);
                }

                for (int i = sink; i != source; i = parent[i]) {
                    flow[parent[i]][i] += fl;
                    flow[i][parent[i]] -= fl;
                    res += fl * cost[parent[i]][i];
                }
            }

            bw.write(String.valueOf(res));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
                }
            }
        }
    }
}
