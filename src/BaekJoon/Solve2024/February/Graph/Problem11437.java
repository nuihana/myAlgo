package BaekJoon.Solve2024.February.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11437 {
    List<Integer>[] edge;
    int[] parent, level;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        edge = new List[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) edge[i] = new ArrayList<>();
        for (int i = 0; i < nodeCnt - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            edge[parent].add(child);
            edge[child].add(parent);
        }

        parent = new int[nodeCnt + 1];
        level = new int[nodeCnt + 1];
        setTree(1, 0);

        int queryCnt = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private void setTree(int node, int pNode) {
        parent[node] = pNode;
        level[node] = level[pNode] + 1;

        for (int child : edge[node]) {
            if (child == pNode) continue;
            setTree(child, node);
        }
    }

    private int lca(int a, int b) {
        if (level[a] < level[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (level[a] != level[b]) {
            a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
