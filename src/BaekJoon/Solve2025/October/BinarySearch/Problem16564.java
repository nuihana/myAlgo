package BaekJoon.Solve2025.October.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16564 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] levs = new int[n];
        for (int i = 0; i < n; i++) {
            levs[i] = Integer.parseInt(br.readLine());
        }

        long l = 0, r = Integer.MAX_VALUE, mid = -1;
        while (l < r) {
            if ((l + r) / 2 == mid) break;
            mid = (l + r) / 2;

            long tmp = 0;
            for (int i = 0; i < n; i++) {
                if (levs[i] < mid) tmp += mid - levs[i];
                if (tmp > k) break;
            }

            if (tmp > k) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.print(mid);

        br.close();
    }
}
