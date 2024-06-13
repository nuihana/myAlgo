package BaekJoon.Solve2024.June.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2828 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxWidth = Integer.parseInt(st.nextToken());
        int bucket = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int left = 1;
        int move = 0;
        for (int i = 0; i < j; i++) {
            int fall = Integer.parseInt(br.readLine());

            int right = left + bucket - 1;
            if (left > fall) {
                move += left - fall;
                left = fall;
            } else if (fall > right) {
                move += fall - right;
                left += fall - right;
            }
        }

        System.out.print(move);

        br.close();
    }
}
