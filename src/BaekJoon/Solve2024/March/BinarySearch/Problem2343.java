package BaekJoon.Solve2024.March.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2343 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lectureCnt = Integer.parseInt(st.nextToken());
        int brCnt = Integer.parseInt(st.nextToken());

        int[] time = new int[lectureCnt];
        int sum = 0, max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lectureCnt; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            sum += time[i];
            max = Math.max(max, time[i]);
        }

        System.out.print(getMinimumTime(max, sum, brCnt, time));

        br.close();
    }

    private int getMinimumTime(int l, int r, int cnt, int[] src) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (getBRCnt(mid, src) > cnt) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int getBRCnt(int mid, int[] src) {
        int count = 1;
        int remain = mid;
        for (int i = 0; i < src.length; i++) {
            if (remain < src[i]) {
                remain = mid;
                count++;
            }
            remain -= src[i];
        }
        return count;
    }
}
