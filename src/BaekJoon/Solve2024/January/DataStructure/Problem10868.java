package BaekJoon.Solve2024.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10868 {
    int[] segTree, arr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int questCnt = Integer.parseInt(st.nextToken());

        segTree = new int[numCnt * 4];
        arr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 0, numCnt - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(print(1, 0, numCnt - 1, start - 1, end - 1));
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private int init(int idx, int start, int end) {
        if (start == end) return segTree[idx] = arr[start];
        int mid = (start + end) / 2;
        return segTree[idx] = Math.min(init(idx * 2, start, mid), init(idx * 2 + 1, mid + 1, end));
    }

    private int print(int idx, int start, int end, int l, int r) {
        if ((start < l && end < l) || (r < start && r < end)) return Integer.MAX_VALUE;
        if (l <= start && end <= r) return segTree[idx];
        int mid = (start + end) / 2;
        return Math.min(print(idx * 2, start, mid, l, r), print(idx * 2 + 1, mid + 1, end, l, r));
    }
}
