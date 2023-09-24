package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2109 {
    int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        parent = new int[10001];
        for (int i = 1; i <= 10000; i++) parent[i] = i;

        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            que.offer(new int[]{pay, day});
        }

        int res = 0;
        while (!que.isEmpty()) {
            int[] work = que.poll();

            int root = find(work[1]);
            if (root != 0) {
                res += work[0];
                union(root - 1, root);
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
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
