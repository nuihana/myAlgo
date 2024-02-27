package BaekJoon.Solve2024.February.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem10282 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCnt = Integer.parseInt(br.readLine());
        while (testCaseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            List<int[]>[] graph = new List[nodeCnt + 1];
            for (int i = 1; i <= nodeCnt; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int child = Integer.parseInt(st.nextToken());
                int parent = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[parent].add(new int[]{ child, cost });
            }

            Queue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
            for (int[] e : graph[start]) {
                q.offer(e);
            }
            int[] cost = new int[nodeCnt + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[start] = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if (cost[now[0]] > now[1]) cost[now[0]] = now[1];
                else continue;

                for (int[] next : graph[now[0]]) {
                    q.offer(new int[]{ next[0], next[1] + now[1] });
                }
            }

            int cnt = 0;
            int max = 0;
            for (int i = 1; i <= nodeCnt; i++) {
                if (cost[i] < Integer.MAX_VALUE) {
                    cnt++;
                    max = Math.max(max, cost[i]);
                }
            }

            System.out.println(cnt + " " + max);
        }

        br.close();
    }
}
