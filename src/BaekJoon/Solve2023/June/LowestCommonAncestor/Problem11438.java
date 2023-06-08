package BaekJoon.Solve2023.June.LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class Problem11438 {
    List<List<Integer>> tree;
    int[][] ancestorTable;
    int[] depth;
    int bit;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

        int tmp = 1;
        bit = 0;
        while (tmp <= nodeCnt) {
            tmp <<= 1;
            bit++;
        }

        depth = new int[nodeCnt + 1];
        ancestorTable = new int[bit][nodeCnt + 1];

        setDepth(1, 1);

        for (int i = 1; i < bit; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                ancestorTable[i][j] = ancestorTable[i - 1][ancestorTable[i - 1][j]];
            }
        }

        int questionCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < questionCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(lca(a, b)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        for (int i = bit - 1; i >= 0; i--) {
            if ((diff & (1 << i)) > 0) {
                a = ancestorTable[i][a];
            }
        }

        if (a == b) return a;

        for (int i = bit - 1; i >= 0; i--) {
            if (ancestorTable[i][a] != ancestorTable[i][b]) {
                a = ancestorTable[i][a];
                b = ancestorTable[i][b];
            }
        }

        return ancestorTable[0][a];
    }

    private void setDepth(int idx, int depth_) {
        depth[idx] = depth_;

        for (Integer next : tree.get(idx)) {
            if (depth[next] == 0) {
                setDepth(next, depth_ + 1);
                ancestorTable[0][next] = idx;
            }
        }
    }
}
