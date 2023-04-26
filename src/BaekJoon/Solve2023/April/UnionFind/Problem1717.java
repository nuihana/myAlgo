package BaekJoon.Solve2023.April.UnionFind;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1717 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command.equals("0")) {
                uf.union(a, b);
            } else if (command.equals("1")) {
                if (uf.find(a, b)) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
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
