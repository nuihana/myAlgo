package BaekJoon.Solve2023.June.LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class Problem3176 {
    List<Map<Integer, Integer>> tree;
    int[] depth;
    int[][] table;
    int[][] minDist;
    int[][] maxDist;
    int maxDepth;
    int nodeCnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nodeCnt = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            tree.add(new HashMap<>());
        }

        StringTokenizer st;
        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree.get(a).put(b, cost);
            tree.get(b).put(a, cost);
        }

        maxDepth = 1;
        while (nodeCnt >= (1 << maxDepth)) {
            maxDepth++;
        }

        depth = new int[nodeCnt + 1];
        table = new int[maxDepth][nodeCnt + 1];
        minDist = new int[maxDepth][nodeCnt + 1];
        maxDist = new int[maxDepth][nodeCnt + 1];

        setDepth(1, 1); // root node가 1
        setTable();

        int questionCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < questionCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(lca(a, b));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void setDepth(int idx, int cnt) {
        depth[idx] = cnt;

        for (int next : tree.get(idx).keySet()) {
            if (depth[next] == 0) {
                setDepth(next, cnt + 1);
                table[0][next] = idx;

                minDist[0][next] = tree.get(idx).get(next);
                maxDist[0][next] = tree.get(idx).get(next);
            }
        }
    }

    private void setTable() {
        for (int i = 1; i < maxDepth; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                table[i][j] = table[i - 1][table[i - 1][j]];

                minDist[i][j] = Math.min(minDist[i - 1][j], minDist[i - 1][table[i - 1][j]]);
                maxDist[i][j] = Math.max(maxDist[i - 1][j], maxDist[i - 1][table[i - 1][j]]);
            }
        }
    }

    private String lca(int a, int b) {
        if (depth[a] < depth[b]) {// a가 무조건 더 깊은 depth를 가지도록 fix
            int tmp = a;
            a = b;
            b = tmp;
        }

        StringBuilder sb = new StringBuilder();
        int max = 0;
        int min = 1000000;

        //높이 맞추기
        int diff = depth[a] - depth[b];
        for (int i = maxDepth - 1; i >= 0; i--) {
            if((diff & (1 << i)) > 0) {
                max = Math.max(max, maxDist[i][a]);
                min = Math.min(min, minDist[i][a]);

                a = table[i][a];
            }
        }

        if (a == b) {
            sb.append(min).append(" ").append(max);
            return sb.toString();
        }

        for (int i = maxDepth - 1; i >= 0; i--) {
            if (table[i][a] != table[i][b]) {
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));

                a = table[i][a];
                b = table[i][b];
            }
        }
        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));
        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));

        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
