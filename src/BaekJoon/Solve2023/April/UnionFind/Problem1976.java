package BaekJoon.Solve2023.April.UnionFind;

import java.io.*;
import java.util.*;

public class Problem1976 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        int targetNodeCnt = Integer.parseInt(br.readLine());

        UnionFind uf = new UnionFind(nodeCnt);
        for (int i = 1; i <= nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; st.hasMoreTokens(); j++) {
                if (st.nextToken().equals("1")) {
                    if (!uf.find(i, j)) {
                        uf.union(i, j);
                    }
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        boolean flag = true;
        for (int i = 1; i < list.size(); i++) {
            if (!uf.find(list.get(i - 1), list.get(i))) {
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }

    class UnionFind {
        int[] arr;

        public UnionFind(int size) {
            arr = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                arr[i] = i;
            }
        }

        private int findRoot(int idx) {
            while (idx != arr[idx]) {
                idx = arr[idx];
            }

            return idx;
        }
        public void union(int parent, int child) {
            int root = findRoot(parent);
            int child_root = findRoot(child);

            arr[child_root] = root;
        }
        public boolean find(int idx_a, int idx_b) {
            int root_a = findRoot(idx_a);
            int root_b = findRoot(idx_b);

            if (root_a == root_b) {
                return true;
            } else {
                return false;
            }
        }
    }
}