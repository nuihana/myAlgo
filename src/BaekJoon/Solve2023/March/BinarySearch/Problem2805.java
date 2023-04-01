package BaekJoon.Solve2023.March.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2805 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCnt = Integer.parseInt(st.nextToken());
        int needLength = Integer.parseInt(st.nextToken());
        int[] treeArr = new int[treeCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(getMaximumCutHeight(treeArr, 0, treeCnt, needLength)));

        br.close();
        bw.close();
    }

    private int getMaximumCutHeight(int[] arr, int begin, int end, int target) {
        if (begin > end) {
            return 0;
        }

        int mid = (begin + end) / 2;

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            long tmp = arr[i] >= mid ? arr[i] - mid : 0;
            result += tmp;
        }

        if (result >= target) {
            return Math.max(mid, getMaximumCutHeight(arr, mid + 1, end, target));
        } else {
            return getMaximumCutHeight(arr, begin, mid - 1, target);
        }
    }
}
