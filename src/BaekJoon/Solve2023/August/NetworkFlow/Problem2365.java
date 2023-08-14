package BaekJoon.Solve2023.August.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem2365 {
    int n, bias = 50, source = 101, sink = 102, rowSum = 0, colSum = 0;
    int[][] capacity, flow;
    List<Integer>[] edges;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        int[] row = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            row[i] = Integer.parseInt(st.nextToken());
            rowSum += row[i];
        }
        int[] col = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            col[i] = Integer.parseInt(st.nextToken());
            colSum += col[i];
        }

        edges = new ArrayList[103];
        for (int i = 0; i < 103; i++) edges[i] = new ArrayList<>();
        capacity = new int[103][103];

        for (int i = 1; i <= n; i++) {
            edges[source].add(i);
            capacity[source][i] = row[i];

            capacity[i + bias][sink] = col[i];
            edges[i + bias].add(sink);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edges[i].add(j + bias);
                edges[j + bias].add(i);
            }
        }

        int l = 0, r = 10000;
        int ans = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (chk(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.newLine();
        chk(ans);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(flow[i][j + bias] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void init(int x) {
        flow = new int[103][103];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                capacity[i][j + bias] = x;
            }
        }
    }

    private boolean chk(int x) {
        init(x);
        int res = 0;
        while(true) {
            int[] parent = new int[103];
            Arrays.fill(parent, -1);

            Queue<Integer> que = new LinkedList<>();
            que.offer(source);

            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : edges[now]) {
                    if (parent[next] == -1 && capacity[now][next] - flow[now][next] > 0) {
                        parent[next] = now;
                        que.offer(next);
                    }
                }
            }
            int fl = 1000000000;
            if (parent[sink] == -1) break;
            for (int i = sink; i != source; i = parent[i]) {
                fl = Math.min(fl, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            res += fl;
            for (int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += fl;
                flow[i][parent[i]] -= fl;
            }
        }
        return rowSum == colSum && rowSum == res;
    }
}
