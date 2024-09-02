package BaekJoon.Solve2024.September.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1197 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        int[] group = new int[nodeCnt + 1];
        int[] rank = new int[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) group[i] = i;

        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }

        edgeList.sort((a1, a2) -> a1[2] - a2[2]);

        long res = 0;
        for (int[] edge : edgeList) {
            if (find(group, edge[0]) != find(group, edge[1])) {
                res += edge[2];
                union(group, rank, edge[0], edge[1]);
            }
        }

        System.out.print(res);

        br.close();
    }

    private int find(int[] group, int idx) {
        if (group[idx] == idx) return idx;
        return find(group, group[idx]);
    }

    private void union(int[] group, int[] rank, int a, int b) {
        int root_a = find(group, a);
        int root_b = find(group, b);

        if (root_a != root_b) {
            if (rank[root_a] < rank[root_b]) {
                group[root_a] = root_b;
            } else {
                group[root_b] = root_a;

                if (rank[root_a] == rank[root_b]) rank[root_a]++;
            }
        }
    }
}
