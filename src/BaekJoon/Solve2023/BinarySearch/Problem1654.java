package BaekJoon.Solve2023.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1654 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lanCnt = Integer.parseInt(st.nextToken());
        int needCnt = Integer.parseInt(st.nextToken());
        int[] lanArr = new int[lanCnt];

        int max = 0;
        for (int i = 0; i < lanCnt; i++) {
            lanArr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanArr[i]);
        }

        bw.write(Long.toString(getMaximumLength(lanArr, 0, max, needCnt)));

        br.close();
        bw.close();
    }

    private long getMaximumLength(int[] arr, long start, long end, int req) {
        if (start > end) {
            return 0;
        }

        long mid = (start + end) / 2;
        mid = mid == 0 ? 1 : mid;

        int computedLanCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            computedLanCnt += arr[i] / mid;
        }

        if (computedLanCnt < req) {
            return getMaximumLength(arr, start, mid - 1, req);
        } else {
            return Math.max(mid, getMaximumLength(arr, mid + 1, end, req));
        }
    }
}
