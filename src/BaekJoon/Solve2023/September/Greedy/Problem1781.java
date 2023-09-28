package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1781 {
    int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());

            list.add(new int[]{ limit, reward });
        }

        list.sort((a1, a2) -> a2[1] - a1[1]);

        int res = 0;
        for (int[] problem : list) {
            int root = find(problem[0]);

            if (root == 0) continue;
            res += problem[1];
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
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            parent[root_b] = root_a;
        }
    }
}
