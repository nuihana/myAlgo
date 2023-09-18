package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13904 {
    int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        parent = new int[1001];
        for (int i = 1; i < parent.length; i++) parent[i] = i;

        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());

            que.offer(new int[]{day, work});
        }

        int res = 0;
        while(!que.isEmpty()) {
            int[] info = que.poll();

            int root = find(info[0]);
            if (root == 0) continue;
            res += info[1];
            union(root - 1, root);
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
        int ra = find(a);
        int rb = find(b);

        parent[rb] = ra;
    }
}
