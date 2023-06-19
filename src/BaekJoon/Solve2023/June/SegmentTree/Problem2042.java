package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2042 {
    long[] numArr;
    BigInteger[] tree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int changeCnt = Integer.parseInt(st.nextToken());
        int resCnt = Integer.parseInt(st.nextToken());

        numArr = new long[numCnt];
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Long.parseLong(br.readLine());
        }

        tree = new BigInteger[numCnt * 4];
        init(0, numCnt - 1, 1);

        for (int i = 0; i < changeCnt + resCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (command == 1) { // 수정
                update(0, numCnt - 1, 1, a - 1, b - numArr[a - 1]);
                numArr[a - 1] = b;
            } else if (command == 2) { // 출력
                bw.write(String.valueOf(sum(0, numCnt - 1, 1, a - 1, (int) (b - 1))));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private BigInteger init(int start, int end, int node) {
        if (start == end) return tree[node] = new BigInteger(String.valueOf(numArr[start]));
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2).add(init(mid + 1, end, node * 2 + 1));
    }

    private BigInteger sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return BigInteger.ZERO;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right).add(sum(mid + 1, end, node * 2 + 1, left, right));
    }

    private void update(int start, int end, int node, int index, long dif) {
        if (index < start || index > end) return;
        tree[node] = tree[node].add(new BigInteger(String.valueOf(dif)));
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}
