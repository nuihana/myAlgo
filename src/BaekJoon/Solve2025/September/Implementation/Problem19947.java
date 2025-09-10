package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19947 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.print(solve(h, y));

        br.close();
    }

    private int solve(int money, int time) {
        if (time == 0) return money;

        int res = solve((int) (money * 1.05), time - 1);
        if (time >= 5) res = Math.max(res, solve((int) (money * 1.35), time - 5));
        if (time >= 3) res = Math.max(res, solve((int) (money * 1.2), time - 3));
        return res;
    }
}
