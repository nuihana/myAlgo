package BaekJoon.Solve2023.June.SweepingAlgorithm;

import java.io.*;
import java.util.*;

public class Problem7626 {
    List<Y> yList;
    int[] cntTree;
    long[] sumTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sqrCnt = Integer.parseInt(br.readLine());
        List<Point> pList = new ArrayList<>();
        yList = new ArrayList<>();
        for (int i = 0; i < sqrCnt; i++) {
            int a = i * 2, b = i * 2 + 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            pList.add(new Point(a, x1));
            pList.add(new Point(b, x2));
            yList.add(new Y(a, y1));
            yList.add(new Y(b, y2));
        }

        yList.sort((y1, y2) -> y1.val - y2.val);
        for (int i = 0; i < yList.size(); i++) {
            Y y = yList.get(i);
            int arr_idx = y.idx / 2;
            if (y.idx % 2 == 0) {
                pList.get(arr_idx * 2).y1 = i;
                pList.get(arr_idx * 2 + 1).y1 = i;
            } else {
                pList.get(arr_idx * 2).y2 = i;
                pList.get(arr_idx * 2 + 1).y2 = i;
            }
        }

        cntTree = new int[sqrCnt * 8];
        sumTree = new long[sqrCnt * 8];
        long result = 0;
        pList.sort((p1, p2) -> p1.val - p2.val);
        for (int i = 0; i < pList.size(); i++) {
            if (i > 0) result += sumTree[1] * (pList.get(i).val - pList.get(i - 1).val);

            if (pList.get(i).idx % 2 == 0) update(0, sqrCnt * 2 - 1, 1, pList.get(i).y1, pList.get(i).y2 - 1, 1); // sqr 시작선
            else update(0, sqrCnt * 2 - 1, 1, pList.get(i).y1, pList.get(i).y2 - 1, -1); // sqr 끝
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private void update(int start, int end, int node, int left, int right, int val) {
        int mid = (start + end) / 2;
        if (start >= left && end <= right) {
            cntTree[node] += val;
        } else {
            if (left <= mid) update(start, mid, node * 2, left, right, val);
            if (mid < right) update(mid + 1, end, node * 2 + 1, left, right, val);
        }

        if (cntTree[node] > 0) {
            sumTree[node] = yList.get(end + 1).val - yList.get(start).val;
        } else {
            if (start == end) sumTree[node] = 0;
            else sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
        }
    }

    class Point {
        int val;
        int idx;
        int y1;
        int y2;

        public Point(int idx_, int val_) {
            idx = idx_;
            val = val_;
        }
    }

    class Y {
        int idx;
        int val;

        public Y(int idx_, int val_) {
            idx = idx_;
            val = val_;
        }
    }
}
