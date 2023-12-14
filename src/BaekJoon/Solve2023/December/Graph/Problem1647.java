package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1647 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        Queue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            que.offer(new int[]{ from, to, cost });
        }

        uf = new int[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) uf[i] = i;
        List<Integer> costs = new ArrayList<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (find(now[0]) != find(now[1])) {
                union(now[0], now[1]);
                costs.add(now[2]);
            }
        }

        costs.sort(Comparator.naturalOrder());
        int result = 0;
        for (int i = 0; i < costs.size() - 1; i++) {
            result += costs.get(i);
        }

        System.out.print(result);

        br.close();
    }

    private int find(int idx) {
        if (idx == uf[idx]) return idx;
        return uf[idx] = find(uf[idx]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) uf[root_b] = root_a;
    }
}
