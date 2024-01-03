package BaekJoon.Solve2024.January.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2512 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] req = new int[cnt];

        int l = 1;
        int r = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            req[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, req[i]);
        }

        int total = Integer.parseInt(br.readLine());
        int result = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int res = 0;
            for (int i = 0; i < cnt; i++) {
                res += Math.min(req[i], mid);
            }

            if (res > total) {
                r = mid - 1;
            } else if (res == total){
                result = mid;
                break;
            } else {
                result = mid;
                l = mid + 1;
            }
        }

        System.out.print(result);

        br.close();
    }
}
