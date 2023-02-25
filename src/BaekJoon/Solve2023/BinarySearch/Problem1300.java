package BaekJoon.Solve2023.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1300 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrSize = Integer.parseInt(br.readLine());
        int targetIdx = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = targetIdx;

        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;

            for (int i = 1; i <= arrSize; i++) {
                cnt += Math.min(mid / i, arrSize);
            }

            if (targetIdx <= cnt) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.print(Long.toString(lo));

        br.close();
    }
}
