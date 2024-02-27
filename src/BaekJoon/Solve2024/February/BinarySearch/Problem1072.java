package BaekJoon.Solve2024.February.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1072 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tot = Integer.parseInt(st.nextToken());
        int win = Integer.parseInt(st.nextToken());
        int rate = (int) ((long) win * 100 / tot);

        int ans = -1;
        int l = 0;
        int r = (int) 1e9;
        while (l <= r) {
            int mid = (l + r) / 2;
            int avg = (int) ((long) (win + mid) * 100 / (tot + mid));
            if (rate != avg) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.print(ans);

        br.close();
    }
}
