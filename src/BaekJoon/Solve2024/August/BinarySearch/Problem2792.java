package BaekJoon.Solve2024.August.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2792 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int colorCnt = Integer.parseInt(st.nextToken());

        int r = 0;
        int[] colors = new int[colorCnt];
        for (int i = 0; i < colorCnt; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, colors[i]);
        }

        int l = 1, res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int rec = 0;
            for (int i = 0; i < colorCnt; i++) {
                rec += colors[i] % mid == 0 ? colors[i] / mid : colors[i] / mid + 1;
            }

            if (rec <= n) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(res);

        br.close();
    }
}
