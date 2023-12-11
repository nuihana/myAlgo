package BaekJoon.Solve2023.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem9205 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> edge = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                edge.add(new int[]{ x, y });
            }

            List<Integer>[] road = new ArrayList[n + 2];
            for (int i = 0; i < n + 2; i++) road[i] = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                int[] now = edge.get(i);
                for (int j = 0; j < n + 2; j++) {
                    if (i == j) continue;
                    int[] next = edge.get(j);
                    int dist = Math.abs(next[0] - now[0]) + Math.abs(next[1] - now[1]);
                    if (dist > 1000) continue;
                    road[i].add(j);
                }
            }

            boolean[] can = new boolean[n + 2];
            can[0] = true;
            Queue<Integer> que = new LinkedList<>();
            que.offer(0);
            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : road[now]) {
                    if (can[next]) continue;
                    can[next] = true;
                    que.offer(next);
                }
            }

            if (can[n + 1]) System.out.println("happy");
            else System.out.println("sad");
        }

        br.close();
    }
}
