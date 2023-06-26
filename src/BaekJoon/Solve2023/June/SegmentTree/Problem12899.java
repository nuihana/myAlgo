package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12899 {
    int[] tree;
    final int MAX = 2000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int queryCnt = Integer.parseInt(br.readLine());
        tree = new int[(1 << 22)];
        for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (query.equals("1")) {
                update(0, MAX - 1, 1, value - 1);
            } else if (query.equals("2")) {
                bw.write(String.valueOf(delete(0, MAX - 1, 1, value) + 1));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private int update(int start, int end, int node, int idx) {
        if (start == end) {
            tree[node]++;
            return tree[node];
        }

        int mid = (start + end) / 2;
        if (idx <= mid) update(start, mid, node * 2, idx);
        if (idx > mid) update(mid + 1, end, node * 2 + 1, idx);
        return tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private int delete(int start, int end, int node, int rank) {
        if (start == end) {
            tree[node]--;
            return start;
        }
        int mid = (start + end) / 2;
        int ret = 0;
        if (rank <= tree[node * 2]) {
            ret = delete(start, mid, node * 2, rank);
        } else {
            ret = delete(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return ret;
    }
}
