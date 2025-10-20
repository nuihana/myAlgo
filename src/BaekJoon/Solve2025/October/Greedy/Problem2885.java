package BaekJoon.Solve2025.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2885 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int tot = 1;
        while (tot < k) {
            tot *= 2;
        }

        int tmp = tot;
        int cnt = 0;
        while (k > 0) {
            if (tmp > k) {
                tmp /= 2;
                cnt++;
                continue;
            }
            if (tmp == k) break;
            k -= tmp;
        }
        System.out.print(tot + " " + cnt);

        br.close();
    }
}
