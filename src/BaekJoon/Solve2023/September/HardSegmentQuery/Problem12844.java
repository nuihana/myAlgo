package BaekJoon.Solve2023.September.HardSegmentQuery;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12844 {
    int[] arr, segTree, lazy;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int height = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        int size = (1 << height);
        segTree = new int[size];
        lazy = new int[size];
        init(0, n - 1, 1);

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (command.equals("1")) {
                int value = Integer.parseInt(st.nextToken());
                if (from > to) update(0, n - 1, 1, to, from, value);
                else update(0, n - 1, 1, from, to, value);
            }
            if (command.equals("2")) {
                if (from > to) bw.write(String.valueOf(query(0, n - 1, 1, to, from)));
                else bw.write(String.valueOf(query(0, n - 1, 1, from, to)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private int init(int start, int end, int node) {
        if (start == end) return segTree[node] = arr[start];
        int mid = (start + end) / 2;
        return segTree[node] = init(start, mid, node * 2) ^ init(mid + 1, end, node * 2 + 1);
    }

    private void lazyUpdate(int start, int end, int node) {
        if (lazy[node] != 0) {
            segTree[node] ^= lazy[node] * ((end - start + 1) % 2);
            if (start != end) {
                lazy[node * 2] ^= lazy[node];
                lazy[node * 2 + 1] ^= lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private void update(int start, int end, int node, int left, int right, int diff) {
        lazyUpdate(start, end, node);
        if (left > end || right < start) return;
        if (left <= start && end <= right) {
            segTree[node] ^= diff * ((end - start + 1) % 2);
            if (start != end) {
                lazy[node * 2] ^= diff;
                lazy[node * 2 + 1] ^= diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, diff);
        update(mid + 1, end, node * 2 + 1, left, right, diff);
        segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
    }

    private int query(int start, int end, int node, int left, int right) {
        lazyUpdate(start, end, node);
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) ^ query(mid + 1, end, node * 2 + 1, left, right);
    }
}
