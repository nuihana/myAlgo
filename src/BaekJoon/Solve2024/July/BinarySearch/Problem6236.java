package BaekJoon.Solve2024.July.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem6236 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] plan = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());

            plan[i] = money;
            min = Math.min(min, money);
            max = Math.max(max, money);
        }

        int l = max;
        int r = 10000 * n;
        int ans = r;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (isPlan(plan, mid, m)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);

        br.close();
    }

    private boolean isPlan(int[] plan, int x, int pur) {
        int cnt = 1;
        int cur = x;

        for (int money : plan) {
            if (cur < money) {
                if (cnt >= pur) return false;

                cnt++;
                cur = x;
            }
            cur -= money;
        }

        return cnt <= pur;
    }
}
