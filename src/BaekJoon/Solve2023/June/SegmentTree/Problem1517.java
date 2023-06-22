package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1517 {
    int[][] numArr;
    long[] segTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        numArr = new int[numCnt][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i][0] = Integer.parseInt(st.nextToken());
            numArr[i][1] = i;
        }

        segTree = new long[numCnt * 4];
        init(0, numCnt - 1, 1);

        Arrays.sort(numArr, (a1, a2) -> a1[0] - a2[0]);
        long result = 0;
        for (int i = 0; i < numCnt; i++) {
            result += query(0, numCnt - 1, 1, 0, numArr[i][1]) - 1;
            update(0, numCnt - 1, 1, numArr[i][1], 0);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private long init(int start, int end, int node) {
        if (start == end) return segTree[node] = 1;
        int mid = (start + end) / 2;
        return segTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private long query(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    private void update(int start, int end, int node, int idx, int val) {
        if (start > idx || end < idx) return;
        if (start == end) {
            segTree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);
        segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
    }
}
