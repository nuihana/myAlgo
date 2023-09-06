package BaekJoon.Solve2023.September.HardSegmentQuery;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1395 {
    int[] tree, lazy;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[4 * n];
        lazy = new int[4 * n];

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (command.equals("0")) {
                update(1, n, 1, from, to);
            } else if (command.equals("1")) {
                bw.write(String.valueOf(query(1, n, 1, from, to)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private void lazyUpdate(int start, int end, int node) {
        if (lazy[node] % 2 == 1) {
            tree[node] = (end - start + 1) - tree[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private void update(int start, int end, int node, int left, int right) {
        lazyUpdate(start, end, node);
        if (end < left || start > right) return;
        if (left <= start && end <= right) {
            lazy[node] = 1;
            lazyUpdate(start, end, node);
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right);
        update(mid + 1, end, node * 2 + 1, left, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int query(int start, int end, int node, int left, int right) {
        lazyUpdate(start, end, node);
        if (end < left || start > right) return 0;
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }
}
