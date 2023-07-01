package BaekJoon.Solve2023.June.SweepingAlgorithm;

import java.io.*;
import java.util.*;

public class Problem17131 {
    long[] segTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCnt = Integer.parseInt(br.readLine());
        List<int[]> starList = new ArrayList<>();
        for (int i = 0; i < starCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            starList.add(new int[]{x, y});
        }

        starList.sort((a1, a2) -> a1[0] - a2[0]);
        int prev = -2000000;
        int rank = -1;
        for (int[] p : starList) {
            if (prev != p[0]) rank++;
            prev = p[0];
            p[0] = rank;
        }

        starList.sort((a1, a2) -> a2[1] - a1[1]);

        segTree = new long[starCnt * 4];
        Queue<int[]> storeQue = new LinkedList<>();
        prev = starList.get(0)[1];
        long result = 0;
        for (int[] p : starList) {
            if (prev != p[1]) {
                prev = p[1];
                while(!storeQue.isEmpty()) {
                    int[] tmp = storeQue.poll();
                    update(0, starCnt - 1, 1, tmp[0]);
                }
            }
            storeQue.offer(p);

            long left = select(0, starCnt - 1, 1, 0, p[0] - 1);
            long right = select(0, starCnt - 1, 1, p[0] + 1, starCnt - 1);

            result += (left * right) % 1000000007;
            result %= 1000000007;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private long select(int start, int end, int node, int left, int right) {
        if (end < left || start > right) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return select(start, mid, node * 2, left, right) +
                select(mid + 1, end, node * 2 + 1, left, right);
    }

    private void update(int start, int end, int node, int idx) {
        if (idx < start || idx > end) return;
        segTree[node]++;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx);
        update(mid + 1, end, node * 2 + 1, idx);
    }
}
