package BaekJoon.Solve2023.August.Mcmf;

import java.io.*;
import java.util.*;

public class Problem11409 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int source = 801, sink = 802;
        int[][] capacity = new int[803][803];
        int[][] flow = new int[803][803];
        int[][] cost = new int[803][803];
        List<Integer>[] edges = new ArrayList[803];
        for (int i = 0; i < 803; i++) edges[i] = new ArrayList<>();

        //source -> worker
        for (int i = 1; i <= n; i++) {
            capacity[source][i] = 1;

            edges[source].add(i);
            edges[i].add(source);
        }

        //work -> sink
        int bias = 400;
        for (int i = 1; i <= m; i++) {
            capacity[i + bias][sink] = 1;

            edges[i + bias].add(sink);
            edges[sink].add(i + bias);
        }

        //worker -> work
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int workCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < workCnt; j++) {
                int work = Integer.parseInt(st.nextToken());
                int pay = Integer.parseInt(st.nextToken());

                capacity[i][work + bias] = 1;

                edges[i].add(work + bias);
                edges[work + bias].add(i);

                cost[i][work + bias] = pay;
                cost[work + bias][i] = -pay;
            }
        }

        int result = 0;
        int cnt = 0;
        while (true) {
            int[] parent = new int[803];
            Arrays.fill(parent, -1);
            int[] payment = new int[803];
            Arrays.fill(payment, -987654321);
            boolean[] inQ = new boolean[803];

            Queue<Integer> que = new LinkedList<>();
            que.offer(source);
            payment[source] = 0;
            inQ[source] = true;
            que.offer(source);

            while (!que.isEmpty()) {
                int now = que.poll();
                inQ[now] = false;
                for (int next : edges[now]) {
                    if (capacity[now][next] - flow[now][next] > 0 && payment[next] < payment[now] + cost[now][next]) {
                        payment[next] = payment[now] + cost[now][next];
                        parent[next] = now;
                        if (!inQ[next]) {
                            que.offer(next);
                            inQ[next] = true;
                        }
                    }
                }
            }

            if (parent[sink] == -1) break;

            int fl = 987654321;
            for (int i = sink; i != source; i = parent[i]) {
                fl = Math.min(fl, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            for (int i = sink; i != source; i = parent[i]) {
                result += fl * cost[parent[i]][i];
                flow[parent[i]][i] += fl;
                flow[i][parent[i]] -= fl;
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
