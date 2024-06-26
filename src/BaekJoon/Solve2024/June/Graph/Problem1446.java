package BaekJoon.Solve2024.June.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1446 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int nodeCnt = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new List[nodeCnt + 1];
        for (int i = 0; i <= nodeCnt; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(new int[]{ i + 1, 1 });
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (to > nodeCnt || dist > to - from) continue;
            graph[from].add(new int[]{ to, dist });
        }

        int[] cost = new int[nodeCnt + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        cost[0] = 0;
        q.offer(new int[]{ 0, 0 });
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] >= nodeCnt) continue;

            for (int[] next : graph[now[0]]) {
                if (now[1] + next[1] < cost[next[0]]) {
                    cost[next[0]] = now[1] + next[1];
                    q.offer(new int[]{ next[0], now[1] + next[1] });
                }
            }
        }

        System.out.print(cost[nodeCnt]);

        br.close();
    }
}
