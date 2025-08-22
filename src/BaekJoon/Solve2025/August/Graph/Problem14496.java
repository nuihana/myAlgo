package BaekJoon.Solve2025.August.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14496 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] res = new int[nodeCnt + 1];
        boolean[] isVisited = new boolean[nodeCnt + 1];
        Arrays.fill(res, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        res[from] = 0;
        isVisited[from] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!isVisited[next]) {
                    res[next] = res[cur] + 1;
                    isVisited[next] = true;
                    q.offer(next);
                }
            }
        }
        System.out.print(res[to]);

        br.close();
    }
}
