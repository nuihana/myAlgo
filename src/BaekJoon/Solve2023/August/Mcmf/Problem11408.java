package BaekJoon.Solve2023.August.Mcmf;

import java.io.*;
import java.util.*;

public class Problem11408 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int source = 801, sink = 802;
        int[][] capacity = new int[803][803], flow = new int[803][803], distance = new int[803][803];
        List<Integer>[] edges = new ArrayList[803];
        for (int i = 1; i < edges.length; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            capacity[source][i] = 1;

            edges[source].add(i);
            edges[i].add(source);
        }

        int bias = 400;
        for (int i = 1; i <= m; i++) {
            capacity[i + bias][sink] = 1;

            edges[i + bias].add(sink);
            edges[sink].add(i + bias);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int wCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < wCnt; j++) {
                int work = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges[i].add(work + bias);
                edges[work + bias].add(i);

                distance[i][work + bias] = cost;
                distance[work + bias][i] = -cost;

                capacity[i][work + bias] = 1;
            }
        }

        int result = 0;
        int cnt = 0;

        while (true) {
            int[] prev = new int[803];
            Arrays.fill(prev, -1);
            int[] dist = new int[803];
            Arrays.fill(dist, 987654321);
            boolean[] inq = new boolean[803];

            Queue<Integer> que = new LinkedList<>();
            dist[source] = 0;
            inq[source] = true;
            que.offer(source);

            while (!que.isEmpty()) {
                int now = que.poll();
                inq[now] = false;
                for (int next : edges[now]) {
                    if (capacity[now][next] - flow[now][next] > 0 && dist[next] > dist[now] + distance[now][next]) {
                        dist[next] = dist[now] + distance[now][next];
                        prev[next] = now;
                        if (!inq[next]) {
                            que.offer(next);
                            inq[next] = true;
                        }
                    }
                }
            }

            if (prev[sink] == -1) break;

            int fl = 987654321;
            for (int i = sink; i != source; i = prev[i]) {
                fl = Math.min(fl, capacity[prev[i]][i] - flow[prev[i]][i]);
            }
            for (int i = sink; i != source; i = prev[i]) {
                result += fl * distance[prev[i]][i];
                flow[prev[i]][i] += fl;
                flow[i][prev[i]] -= fl;
            }

            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
