package BaekJoon.Solve2025.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11948 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tmp = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(br.readLine());
            res += score;
            tmp = Math.min(tmp, score);
        }

        res -= tmp;
        tmp = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int score = Integer.parseInt(br.readLine());
            res += score;
            tmp = Math.min(tmp, score);
        }
        res -= tmp;

        System.out.print(res);

        br.close();
    }
}
