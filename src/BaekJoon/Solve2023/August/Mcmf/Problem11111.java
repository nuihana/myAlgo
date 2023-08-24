package BaekJoon.Solve2023.August.Mcmf;

import java.io.*;
import java.util.*;

public class Problem11111 {
    int n, m;
    int[][] capacity, price;
    char[][] worth;
    int[][] worthMap = {
            {10, 8, 7, 5, 1},
            {8, 6, 4, 3, 1},
            {7, 4, 3, 2, 1},
            {5, 3, 2, 2, 1},
            {1, 1, 1, 1, 0}
    };
    List<Integer>[] edges;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int source = 2501;
        int sink = 2502;
        int len = sink + 1;
        capacity = new int[len][len];
        price = new int[len][len];
        int[][] flow = new int[len][len];
        edges = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            edges[i] = new ArrayList<>();
        }

        worth = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                worth[i][j] = line.charAt(j);
                if (worth[i][j] == 'F') worth[i][j] = 'E';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int idx = (i - 1) * m + j;
                if ((i + j) % 2 == 0) {
                    addEdge(source, idx);
                    if (i > 1) addEdge(idx, idx - m);
                    if (i < n) addEdge(idx, idx + m);
                    if (j > 1) addEdge(idx, idx - 1);
                    if (j < m) addEdge(idx, idx + 1);
                }
                addEdge(idx, sink);
            }
        }

        int res = 0;
        while(true) {
            int[] parent = new int[len];
            Arrays.fill(parent, -1);

            int[] cost = new int[len];
            Arrays.fill(cost, 987654321);

            boolean[] inQ = new boolean[len];
            Queue<Integer> que = new LinkedList<>();

            que.offer(source);
            inQ[source] = true;
            cost[source] = 0;

            while(!que.isEmpty()) {
                int now = que.poll();
                inQ[now] = false;
                for (int next : edges[now]) {
                    if (cost[next] > cost[now] + price[now][next]
                    && capacity[now][next] - flow[now][next] > 0) {
                        cost[next] = cost[now] + price[now][next];
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
                res += fl * price[parent[i]][i];
                flow[parent[i]][i] += fl;
                flow[i][parent[i]] -= fl;
            }
        }

        bw.write(String.valueOf(-res));

        br.close();
        bw.close();
    }

    private void addEdge(int from, int to) {
        edges[from].add(to);
        edges[to].add(from);

        capacity[from][to] = 1;

        int cost;
        int[] a = getXY(from);
        int[] b = getXY(to);
        if (from <= 2500 && to <= 2500) {
            cost = -worthMap[worth[a[0]][a[1]] - 65][worth[b[0]][b[1]] - 65];
        } else {
            cost = 0;
        }

        price[from][to] = cost;
        price[to][from] = -cost;
    }

    private int[] getXY(int idx) {
        return new int[]{(idx - 1) / m, (idx - 1) % m};
    }
}
