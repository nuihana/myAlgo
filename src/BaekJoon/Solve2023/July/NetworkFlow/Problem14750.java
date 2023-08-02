package BaekJoon.Solve2023.July.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem14750 {
    List<int[]> wall;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 벽을 이루는 점
        int k = Integer.parseInt(st.nextToken()); // 구멍이 수용할 수 있는 상한선
        int h = Integer.parseInt(st.nextToken()); // 구멍 수
        int m = Integer.parseInt(st.nextToken()); // 쥐 수

        wall = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            wall.add(new int[]{x, y});
        }
        wall.add(new int[]{wall.get(0)[0], wall.get(0)[1]});

        List<int[]> hole = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hole.add(new int[]{x, y});
        }

        List<int[]> mouse = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            mouse.add(new int[]{x, y});
        }

        int source = 0;
        int sink = h + m + 1;
        int len = sink + 1;
        int[][] capacity = new int[len][len], flow = new int[len][len];
        List<Integer>[] edges = new ArrayList[len];
        for (int i = 0; i < len; i++) edges[i] = new ArrayList<>();

        // source > mouse
        for (int i = 1; i <= m; i++) {
            edges[source].add(i);
            edges[i].add(source);
            capacity[source][i] = 1;
        }

        // hole > sink
        for (int i = m + 1; i <= m + h; i++) {
            edges[sink].add(i);
            edges[i].add(sink);
            capacity[i][sink] = k;
        }

        // mouse > hole
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < h; j++) {
                if (!isCrossed(mouse.get(i), hole.get(j))) {
                    edges[i + 1].add(j + m + 1);
                    edges[j + m + 1].add(i + 1);
                    capacity[i + 1][j + m + 1] = 1;
                }
            }
        }

        int maxFlow = 0;
        while (true) {
            int minFlow = Integer.MAX_VALUE;
            int[] parent = new int[len];
            Queue<Integer> que = new ArrayDeque<>();

            Arrays.fill(parent, -1);
            que.add(source);
            parent[source] = source;

            while (!que.isEmpty() && parent[sink] == -1) {
                int now = que.poll();

                for (int next : edges[now]) {
                    if (capacity[now][next] - flow[now][next] > 0 && parent[next] == -1) {
                        que.offer(next);
                        parent[next] = now;
                    }
                }
            }

            if (parent[sink] == -1) break;

            for (int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for (int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            maxFlow += minFlow;
        }

        if (m == maxFlow) bw.write("Possible");
        else bw.write("Impossible");

        br.close();
        bw.close();
    }

    private long ccw(int[] a, int[] b, int[] c) {
        long s = (long) (b[0] - a[0]) * (long) (c[1] - a[1]);
        s -= (long) (b[1] - a[1]) * (long) (c[0] - a[0]);
        return s == 0 ? 0 : s > 0 ? 1 : -1;
    }

    private boolean isLine(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a, b, c, d;
        if (p1[0] == p2[0]) {
            a = Math.min(p1[1], p2[1]);
            b = Math.max(p1[1], p2[1]);
            c = Math.min(p3[1], p4[1]);
            d = Math.max(p3[1], p4[1]);
        } else {
            a = Math.min(p1[0], p2[0]);
            b = Math.max(p1[0], p2[0]);
            c = Math.min(p3[0], p4[0]);
            d = Math.max(p3[0], p4[0]);
        }

        return a <= d && c <= b;
    }

    private boolean isCrossed(int[] m, int[] h) {
        int cnt = 0;
        for (int i = 0; i < wall.size() - 1; i++) {
            int[] p1 = wall.get(i), p2 = wall.get(i + 1);
            if (h[0] == p1[0] && h[1] == p1[1]) continue;

            long s1 = ccw(m, h, p1);
            long s2 = ccw(m, h, p2);
            long s3 = ccw(p1, p2, m);
            long s4 = ccw(p1, p2, h);
            long s12 = s1 * s2;
            long s34 = s3 * s4;

            if (s12 <= 0 && s34 < 0 || s12 < 0 && s34 <= 0) cnt++;
            else if (s12 == 0 && s34 == 0 && isLine(p1, p2, m, h)) cnt++;

            if (cnt > 1) return true;
        }
        return false;
    }
}
