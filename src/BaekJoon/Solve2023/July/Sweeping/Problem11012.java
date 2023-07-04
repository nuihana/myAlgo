package BaekJoon.Solve2023.July.Sweeping;

import java.io.*;
import java.util.*;

public class Problem11012 {
    final int MAX_RANGE = 100001;
    long[] tree;
    long[] lazy;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeCnt = Integer.parseInt(st.nextToken());
            int paradeCnt = Integer.parseInt(st.nextToken());

            List<int[]> paradeList = new ArrayList<>();
            for (int j = 0; j < homeCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                paradeList.add(new int[]{x, y, 0, 0});
            }

            for (int j = 0; j < paradeCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                paradeList.add(new int[]{x1, y1, y2, 1});
                paradeList.add(new int[]{x2, y1, y2, 2});
            }

            tree = new long[MAX_RANGE * 4];
            lazy = new long[MAX_RANGE * 4];
            paradeList.sort((a1, a2) -> a1[0] - a2[0]);
            long res = 0;
            for (int[] info : paradeList) {
                if (info[3] == 0) { // 집있는 곳
                    res += select(0, MAX_RANGE - 1, 1, info[1]);
                } else {
                    if (info[3] == 1) { // 퍼레이드 시작점
                        update(0, MAX_RANGE - 1, 1, info[1], info[2], 1);
                    } else { // 퍼레이드 종료점
                        update(0, MAX_RANGE - 1, 1, info[1], info[2], -1);
                    }
                }
            }

            bw.write(String.valueOf(res));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void updateLazy(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += (lazy[node] * (end - start + 1));

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    private void update(int start, int end, int node, int left, int right, int val) {
        updateLazy(start, end, node);

        if (end < left || start > right) return;
        if (left <= start && end <= right) {
            tree[node] += (val * (end - start + 1));

            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, left, right, val);
        update(mid + 1, end, node * 2 + 1, left, right, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private long select(int start, int end, int node, int idx) {
        updateLazy(start, end, node);
        if (idx < start || end < idx) return 0;
        if (start == end) return tree[node];
        int mid = (start + end) / 2;
        return select(start, mid, node * 2, idx) + select(mid + 1, end, node * 2 + 1, idx);
    }
}
