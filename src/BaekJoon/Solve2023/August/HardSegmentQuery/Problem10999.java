package BaekJoon.Solve2023.August.HardSegmentQuery;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10999 {
    long[] arr, segTree, lazyMem;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int updateCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        arr = new long[numCnt];
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        segTree = new long[numCnt * 4];
        lazyMem = new long[numCnt * 4];
        init(0, numCnt - 1, 1);

        for (int i = 0; i < updateCnt + queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (command.equals("1")) {
                long diff = Long.parseLong(st.nextToken());
                update(0, numCnt - 1, 1, from - 1, to - 1, diff);
            } else if (command.equals("2")) {
                bw.write(String.valueOf(query(0, numCnt - 1, 1, from - 1, to - 1)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private long init(int start, int end, int node) {
        if (start == end) return segTree[node] = arr[start];
        int mid = (start + end) / 2;
        return segTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private void propagate(int start, int end, int node) {
        if (lazyMem[node] != 0) {
            segTree[node] += (end - start + 1) * lazyMem[node];
            if (start != end) {
                lazyMem[node * 2] += lazyMem[node];
                lazyMem[node * 2 + 1] += lazyMem[node];
            }
            lazyMem[node] = 0;
        }
    }

    private void update(int start, int end, int node, int left, int right, long diff) {
        propagate(start, end, node);
        if (right < start || left > end) return;
        if (left <= start && end <= right) {
            segTree[node] += diff * (end - start + 1);
            if (start != end) {
                lazyMem[node * 2] += diff;
                lazyMem[node * 2 + 1] += diff;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, diff);
        update(mid + 1, end, node * 2 + 1, left, right, diff);
        segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
    }

    private long query(int start, int end, int node, int left, int right) {
        propagate(start, end, node);
        if (right < start || left > end) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }
}
