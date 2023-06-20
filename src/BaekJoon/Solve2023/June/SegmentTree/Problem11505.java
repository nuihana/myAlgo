package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11505 {
    int numCnt;
    static final int MOD = 1000000007;
    int[] numArr;
    long[] tree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());
        commandCnt += Integer.parseInt(st.nextToken());

        numArr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        tree = new long[numCnt * 4];
        init(0, numCnt - 1, 1);

        for (int i = 0; i < commandCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 1) {
                numArr[a - 1] = b;
                update(0, numCnt - 1, 1, a - 1, b);
            } else if (command == 2) {
                bw.write(String.valueOf(print(0, numCnt - 1, 1, a - 1, b - 1)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private long init(int start, int end, int node) {
        if (start == end) return tree[node] = numArr[start];
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    private long update(int start, int end, int node, int index, int val) {
        if (index < start || end < index) return tree[node];
        if (start == end) return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, index, val) * update(mid + 1, end, node * 2 + 1, index, val)) % MOD;
    }

    private long print(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return (print(start, mid, node * 2, left, right) * print(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }
}
