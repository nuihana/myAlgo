package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bird = Integer.parseInt(br.readLine());

        int res = 1;
        int num = 1;
        while (true) {
            if (bird < num) num = 1;

            bird -= num++;

            if (bird == 0) break;
            res++;
        }
        System.out.print(res);

        br.close();
    }
}
