package BaekJoon.Solve2023.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1414 {
    int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                if (line.charAt(j - 1) == '0') continue;
                que.offer(new int[]{ i, j, getLength(line.charAt(j - 1)) }); // from, to, len
            }
        }

        int res = 0;
        List<int[]> mst = new ArrayList<>();
        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (find(now[0]) == find(now[1])) { //사이클 발생시 통과
                res += now[2];
                continue;
            }

            mst.add(now);
            union(now[0], now[1]);
        }

        if (mst.size() == n - 1) {
            System.out.print(res);
        } else {
            System.out.print("-1");
        }

        br.close();
    }

    private int getLength(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a' + 1;
        return c - 'A' + 27;
    }

    private int find(int idx) {
        if (parent[idx] == idx) return idx;
        return parent[idx] = find(parent[idx]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) parent[root_b] = root_a;
    }
}
