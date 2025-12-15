package BaekJoon.Solve2025.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15723 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[26];
        for (int i = 0; i < 26; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            graph[a].add(b);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            if (isTrue(graph, a, b)) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isTrue(List<Integer>[] graph, int a, int b) {
        boolean[] isVisited = new boolean[26];
        isVisited[a] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == b) return true;

            for (int next : graph[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }
}
