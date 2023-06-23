package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9345 {
    long[][] segTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseOrd = 0; caseOrd < caseCnt; caseOrd++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int event = Integer.parseInt(st.nextToken());

            int[] idx = new int[cnt];
            for (int i = 1; i < cnt; i++) {
                idx[i] = i;
            }
            segTree = new long[cnt * 4][2];
            init(0, cnt - 1, 1);

            for (int i = 0; i < event; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("0")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    update(0, cnt - 1, 1, idx[a], b);
                    update(0, cnt - 1, 1, idx[b], a);
                    int tmp = idx[a];
                    idx[a] = idx[b];
                    idx[b] = tmp;
                } else if (command.equals("1")) {
                    int from = Integer.parseInt(st.nextToken());
                    int to = Integer.parseInt(st.nextToken());

                    long[] query = print(0, cnt - 1, 1, from, to);

                    if (query[0] == from && query[1] == to) {
                        bw.write("YES");
                    } else {
                        bw.write("NO");
                    }
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.close();
    }

    private long[] init(int start, int end, int node) {
        if (start == end) {
            return segTree[node] = new long[]{start, start};
        }
        int mid = (start + end) / 2;
        long[] left = init(start, mid, node * 2);
        long[] right = init(mid + 1, end, node * 2 + 1);
        return segTree[node] = new long[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
    }

    private long[] print(int start, int end, int node, int left, int right) {
        if (start > right || end < left) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        long[] leftNode = print(start, mid, node * 2, left, right);
        long[] rightNode = print(mid + 1, end, node * 2 + 1, left, right);
        return new long[]{Math.min(leftNode[0], rightNode[0]), Math.max(leftNode[1], rightNode[1])};
    }

    private long[] update(int start, int end, int node, int idx, int num) {
        if (start > idx || end < idx) return segTree[node];
        if (start == end) return segTree[node] = new long[]{num, num};
        int mid = (start + end) / 2;
        long[] left = update(start, mid, node * 2, idx, num);
        long[] right = update(mid + 1, end, node * 2 + 1, idx, num);
        return segTree[node] = new long[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
    }
}
