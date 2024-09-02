package BaekJoon.Solve2024.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1459 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int straight = Integer.parseInt(st.nextToken());
        int across = Integer.parseInt(st.nextToken());
        long res = 0;
        if (across >= straight * 2) {
            res = (long) (x + y) * straight;
        } else {
            int remain = Math.max(x, y) - Math.min(x, y);
            int through = Math.min(x, y);
            res = (long) through * across + (long) remain * straight;
        }

        System.out.print(res);

        br.close();
    }
}
