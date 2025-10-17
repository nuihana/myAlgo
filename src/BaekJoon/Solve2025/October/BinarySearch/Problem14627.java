package BaekJoon.Solve2025.October.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14627 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] leeks = new int[s];
        long sum = 0;
        for (int i = 0; i < s; i++) {
            leeks[i] = Integer.parseInt(br.readLine());
            sum += leeks[i];
        }

        long l = 1, r = 1000000000, res = 0;
        while (l <= r) {
            long mid = (l + r) / 2;

            if (chk(mid, leeks, c)) {
                l = mid + 1;
                res = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.print(sum - (res * c));

        br.close();
    }

    private boolean chk(long div, int[] leeks, int cnt) {
        int res = 0;
        for (int leek : leeks) {
            res += leek / div;
        }
        return res >= cnt;
    }
}
