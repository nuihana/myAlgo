package BaekJoon.Solve2025.August.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13702 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] amount = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, amount[i]);
        }

        long l = 1, r = max, res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += amount[i] / mid;
            }

            if (cnt >= k) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.print(res);

        br.close();
    }
}
