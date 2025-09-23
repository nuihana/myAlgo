package BaekJoon.Solve2025.September.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1527 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.print(search(a, b, 0L, 0));

        br.close();
    }

    private int search(int a, int b, long cur, int cnt) {
        if (cur > b) {
            return cnt;
        }
        if (cur >= a) cnt++;

        cnt = search(a, b, cur * 10 + 4, cnt);
        cnt = search(a, b, cur * 10 + 7, cnt);
        return cnt;
    }
}
