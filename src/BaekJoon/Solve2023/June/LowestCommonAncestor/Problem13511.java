package BaekJoon.Solve2023.June.LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class Problem13511 {
    int nodeCnt;
    List<Map<Integer, Integer>> tree;
    int[] depth;
    long[] length;
    int[][] table;
    int maxBit;
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

        maxBit = 1;
        while (nodeCnt >= (1 << maxBit)) {
            maxBit++;
        }

        table = new int[maxBit][nodeCnt + 1];
        length = new long[nodeCnt + 1];
        depth = new int[nodeCnt + 1];
        setDepth(1, 1);
        setTable();

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int root = lca(a, b);
            if (command == 1) {
                bw.write(String.valueOf(length[a] + length[b] - length[root] * 2));
            } else if (command == 2) {
                int ord = Integer.parseInt(st.nextToken());

                int aLength = depth[a] - depth[root] + 1;
                int resIdx;

                if (aLength == ord) {
                    resIdx = root;
                } else if (aLength > ord) {
                    ord--;
                    for (int j = maxBit - 1; j >= 0; j--) {
                        if ((ord & (1 << j)) > 0) {
                            a = table[j][a];
                        }
                    }
                    resIdx = a;
                } else {
                    ord = aLength + depth[b] - depth[root] - ord;
                    for (int j = maxBit - 1; j >= 0; j--) {
                        if ((ord & (1 << j)) > 0) {
                            b = table[j][b];
                        }
                    }
                    resIdx = b;
                }

                bw.write(String.valueOf(resIdx));
            }
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
                length[next] = length[idx] + tree.get(idx).get(next);
            }
        }
    }

    private void setTable() {
        for (int i = 1; i < maxBit; i++) {
            for (int j = 1; j <= nodeCnt; j++) {
                table[i][j] = table[i - 1][table[i - 1][j]];
            }
        }
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int diff = depth[a] - depth[b];
        for (int i = maxBit - 1; i >= 0; i--) {
            if ((diff & (1 << i)) > 0) {
                a = table[i][a];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = maxBit - 1; i >= 0; i--) {
            if (table[i][a] != table[i][b]) {
                a = table[i][a];
                b = table[i][b];
            }
        }

        return table[0][a];
    }
}
