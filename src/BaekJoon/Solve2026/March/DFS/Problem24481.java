package BaekJoon.Solve2026.March.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem24481 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

        int[] depth = new int[n + 1];
        Arrays.fill(depth, -1);
        boolean[] visited = new boolean[n + 1];

        dfs(graph, depth, visited, r, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(depth[i]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private void dfs(List<Integer>[] graph, int[] depth, boolean[] visited, int idx, int d) {
        visited[idx] = true;
        depth[idx] = d;

        for (int next : graph[idx]) {
            if (!visited[next]) {
                dfs(graph, depth, visited, next, d + 1);
            }
        }
    }
}
