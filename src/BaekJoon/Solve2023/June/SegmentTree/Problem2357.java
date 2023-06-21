package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2357 {
    int[] numArr;
    int[][] segTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        numArr = new int[numCnt];
        for (int i = 0; i < numCnt; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }

        // init
        segTree = new int[numCnt * 4][2]; // 0 : 최소, 1: 최대
        initMin(0, numCnt - 1, 1);
        initMax(0, numCnt - 1, 1);

        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //answer
            bw.write(printMin(0, numCnt - 1, 1, a - 1, b - 1) + " " + printMax(0, numCnt - 1, 1, a - 1, b - 1));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int initMin(int start, int end, int node) {
        if (start == end) return segTree[node][0] = numArr[start];
        int mid = (start + end) / 2;
        return segTree[node][0] = Math.min(initMin(start, mid, node * 2), initMin(mid + 1, end, node * 2 + 1));
    }

    private int initMax(int start, int end, int node) {
        if (start == end) return segTree[node][1] = numArr[start];
        int mid = (start + end) / 2;
        return segTree[node][1] = Math.max(initMax(start, mid, node * 2), initMax(mid + 1, end, node * 2 + 1));
    }

    private int printMin(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (left <= start && right >= end) return segTree[node][0];
        int mid = (start + end) / 2;
        return Math.min(printMin(start, mid, node * 2, left, right), printMin(mid + 1, end, node * 2 + 1, left, right));
    }

    private int printMax(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return Integer.MIN_VALUE;
        if (left <= start && right >= end) return segTree[node][1];
        int mid = (start + end) / 2;
        return Math.max(printMax(start, mid, node * 2, left, right), printMax(mid + 1, end, node * 2 + 1, left, right));
    }
}
