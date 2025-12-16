package BaekJoon.Solve2025.December.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15810 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long l = 1, r = (long) arr[arr.length - 1] * m, res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            long cnt = 0;
            for (int time : arr) cnt += mid / time;

            if (cnt >= m) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.print(res);

        br.close();
    }
}
