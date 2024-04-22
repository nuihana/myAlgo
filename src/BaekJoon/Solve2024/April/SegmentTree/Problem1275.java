package BaekJoon.Solve2024.April.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1275 {
    long[] arr, segmentTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        arr = new long[numCnt];
        segmentTree = new long[numCnt * 4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(0, numCnt - 1, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int idx = Integer.parseInt(st.nextToken()) - 1;
            long val = Long.parseLong(st.nextToken());

            if (from > to) {
                sb.append(query(0, numCnt - 1, 1, to, from)).append("\n");
            } else {
                sb.append(query(0, numCnt - 1, 1, from, to)).append("\n");
            }

            update(0, numCnt - 1, 1, idx, val - arr[idx]);
            arr[idx] = val;
        }

        System.out.print(sb);

        br.close();
    }

    private long init(int start, int end, int node) {
        if (start == end) return segmentTree[node] = arr[start];

        int mid = (start + end) / 2;
        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private long query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return segmentTree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    private void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || idx > end) return;

        segmentTree[node] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}
