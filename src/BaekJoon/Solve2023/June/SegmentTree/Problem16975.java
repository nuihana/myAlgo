package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16975 {
    int[] numArr;
    long[] segTree;
    long[] lazy;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        numArr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        segTree = new long[size * 4];
        lazy = new long[size * 4];
        init(0, size - 1, 1);

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("1")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dif = Integer.parseInt(st.nextToken());

                update(0, size - 1, 1, a - 1, b - 1, dif);
            } else if (cmd.equals("2")) {
                int a = Integer.parseInt(st.nextToken());
                bw.write(String.valueOf(print(0, size - 1, 1, a - 1, a - 1)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private long init(int start, int end, int node) {
        if (start == end) return segTree[node] = numArr[start];
        int mid = (start + end) / 2;
        return segTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private long print(int start, int end, int node, int left, int right) {
        updateLazy(start, end, node);
        if (start > right || end < left) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return print(start, mid, node * 2, left, right) + print(mid + 1, end, node * 2 + 1, left, right);
    }

    private void updateLazy(int start, int end, int node) {
        if (lazy[node] != 0) {
            segTree[node] += (lazy[node] * (end - start + 1));

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    private void update(int start, int end, int node, int left, int right, int dif) {
        updateLazy(start, end, node);

        if (start > right || end < left) return;
        if (left <= start && end <= right) {
            segTree[node] += (dif * (end - start + 1));

            if (start != end) {
                lazy[node * 2] += dif;
                lazy[node * 2 + 1] += dif;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, dif);
        update(mid + 1, end, node * 2 + 1, left, right, dif);
        segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
    }
}
