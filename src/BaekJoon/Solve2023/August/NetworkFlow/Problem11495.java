package BaekJoon.Solve2023.August.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem11495 {
    int source = 0, sink = 1, inf = 987654321, max = 2503;
    int[][] change_pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<Edge>[] edges;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];

            max = 2 + n * m;
            edges = new ArrayList[max];
            for (int i = 0; i < max; i++) {
                edges[i] = new ArrayList<>();
            }

            int total = 0;
            int idx = 2;
            boolean is_red = true;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    total += arr[i][j];

                    if (is_red) {
                        Edge e = new Edge(source, idx, arr[i][j]);
                        Edge rev = new Edge(idx, source, 0);
                        e.rev = rev;
                        rev.rev = e;

                        edges[source].add(e);
                        edges[idx].add(rev);
                    } else {
                        Edge e = new Edge(idx, sink, arr[i][j]);
                        Edge rev = new Edge(sink, idx, 0);
                        e.rev = rev;
                        rev.rev = e;

                        edges[idx].add(e);
                        edges[sink].add(rev);
                    }
                    idx++;
                    is_red = !is_red;
                }
                if (m % 2 == 0) is_red = !is_red;
            }

            int[] change_idx = {m, -m, 1, -1};
            idx = 2;
            is_red = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (is_red) {
                        for (int k = 0; k < 4; k++) {
                            int blue_i = i + change_pos[k][0];
                            int blue_j = j + change_pos[k][1];

                            if (blue_i < 0 || n <= blue_i || blue_j < 0 || m <= blue_j) continue;

                            int blue_idx = idx + change_idx[k];

                            Edge e = new Edge(idx, blue_idx, inf);
                            Edge rev = new Edge(blue_idx, idx, 0);
                            e.rev = rev;
                            rev.rev = e;

                            edges[idx].add(e);
                            edges[blue_idx].add(rev);
                        }
                    }
                    is_red = !is_red;
                    idx++;
                }
                if (m % 2 == 0) is_red = !is_red;
            }

            int max_flow = maximumFlow();
            bw.write(String.valueOf(total - max_flow));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int maximumFlow() {
        int total_flow = 0;

        while (true) {
            Edge[] parent = new Edge[max];

            Queue<Integer> que = new LinkedList<>();
            que.offer(source);

            while (!que.isEmpty()) {
                int now = que.poll();
                if (now == sink) break;

                for (Edge next : edges[now]) {
                    if (parent[next.to] == null && next.capa - next.flow > 0) {
                        que.offer(next.to);
                        parent[next.to] = next;

                        if(next.to==sink) break;
                    }
                }
            }

            if (parent[sink] == null) break;

            int fl = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i].from) {
                fl = Math.min(fl, parent[i].capa - parent[i].flow);
            }

            for (int i = sink; i != source; i = parent[i].from) {
                parent[i].flow += fl;
                parent[i].rev.flow -= fl;
            }

            total_flow += fl;
        }

        return total_flow;
    }

    class Edge {
        int from;
        int to;
        int capa;
        int flow;
        Edge rev;

        public Edge(int s, int e, int c) {
            from = s;
            to = e;
            capa = c;

            flow = 0;
        }
    }
}
