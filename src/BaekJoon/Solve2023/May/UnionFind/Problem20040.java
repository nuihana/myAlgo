package BaekJoon.Solve2023.May.UnionFind;

import java.io.*;
import java.util.StringTokenizer;

public class Problem20040 {
    int[] arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int turnCnt = Integer.parseInt(st.nextToken());

        arr = new int[pointCnt];

        for (int i = 0; i < pointCnt; i++) {
            arr[i] = i;
        }

        int result = 0;
        for (int i = 0; i < turnCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (findRoot(a) == findRoot(b)) {
                result = i + 1;
                break;
            }

            union(a, b);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int findRoot(int idx) {
        while (idx != arr[idx]) {
            idx = arr[idx];
        }

        return idx;
    }

    private void union(int parent, int child) {
        int root = findRoot(parent);
        int child_root = findRoot(child);

        arr[child_root] = root;
    }
}
