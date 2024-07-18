package BaekJoon.Solve2024.July.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1219 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        List<int[]>[] edges = new List[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[from].add(new int[]{ to, cost });
        }

        long INF = 100000000000L;
        long[] dist = new long[nodeCnt];
        Arrays.fill(dist, INF);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodeCnt; i++) {
            int earn = Integer.parseInt(st.nextToken());
            if (i == start) dist[start] = earn * -1;

            for (int j = 0; j < nodeCnt; j++) {
                for (int[] edge : edges[j]) {
                    if (edge[0] == i) edge[1] -= earn;
                }
            }
        }

        for (int i = 0; i <= nodeCnt; i++) {
            if (dist[end] == INF && i == nodeCnt) {
                System.out.print("gg");
                return;
            }

            for (int j = 0; j < nodeCnt; j++) {
                if (dist[j] == INF) continue;

                for (int[] edge : edges[j]) {
                    if (dist[j] + edge[1] < dist[edge[0]]) {
                        dist[edge[0]] = dist[j] + edge[1];
                        if (i == nodeCnt) {
                            if (chk(edge[0], end, nodeCnt, edges)) {
                                System.out.print("Gee");
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(dist[end] * -1);

        br.close();
    }

    private boolean chk(int id, int end, int size, List<int[]>[] edges) {
        boolean[] visit = new boolean[size];
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end) return true;
            visit[now] = true;
            for (int[] edge : edges[now]) {
                if (!visit[edge[0]]) q.offer(edge[0]);
            }
        }
        return false;
    }
}
