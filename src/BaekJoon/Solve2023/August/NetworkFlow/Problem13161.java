package BaekJoon.Solve2023.August.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem13161 {
    int len, source, sink;
    int[][] capacity, flow;
    List<Integer>[] edges;
    int[] level, work, chk;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        source = 0;
        sink = n + 1;
        len = sink + 1;
        int INF = Integer.MAX_VALUE;
        capacity = new int[len][len];
        flow = new int[len][len];
        edges = new ArrayList[len];
        for (int i = 0; i < len; i++) edges[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) { // A팀에 들어가야만 함, Source 와 i 를 무한 capacity로 연결
                capacity[source][i] = INF;
                edges[source].add(i);
                edges[i].add(source);
            }

            if (a == 2) { // B팀에 들어가야만 함, i 와 Sink 를 무한 capacity로 연결
                capacity[i][sink] = INF;
                edges[i].add(sink);
                edges[sink].add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                capacity[i][j] = Integer.parseInt(st.nextToken());
                if (i != j) edges[i].add(j);
            }
        }

        int res = 0;
        while(bfs()) {
            work = new int[len];

            while (true) {
                int fl = dfs(source, INF);
                if (fl == 0) break;
                res += fl;
            }
        }

        bw.write(String.valueOf(res));
        bw.newLine();

        chk = new int[len];
        decom();

        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (chk[i] == 1) teamA.add(i);
            else teamB.add(i);
        }

        for (int i : teamA) bw.write(i + " "); bw.newLine();
        for (int i : teamB) bw.write(i + " "); bw.newLine();

        br.close();
        bw.close();
    }

    private boolean bfs() {
        level = new int[len];
        Arrays.fill(level, -1);

        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        level[source] = 0;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : edges[now]) {
                if (level[next] == -1 && capacity[now][next] - flow[now][next] > 0) {
                    level[next] = level[now] + 1;
                    que.offer(next);
                }
            }
        }

        return level[sink] != -1;
    }

    private int dfs(int now, int tot) {
        if (now == sink) return tot;
        for (; work[now] < edges[now].size(); work[now]++) {
            int next = edges[now].get(work[now]);
            if (level[next] == level[now] + 1 && capacity[now][next] - flow[now][next] > 0) {
                int fl = dfs(next, Math.min(tot, capacity[now][next] - flow[now][next]));
                if (fl > 0) {
                    flow[now][next] += fl;
                    flow[next][now] -= fl;
                    return fl;
                }
            }
        }
        return 0;
    }

    private void decom() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        chk[source] = 1;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : edges[now]) {
                if (chk[next] == 0 && capacity[now][next] - flow[now][next] > 0) {
                    chk[next] = 1;
                    que.offer(next);
                }
            }
        }
    }
}
