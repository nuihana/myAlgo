package BaekJoon.Solve2025.May.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem23795 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            res += num;
        }
        System.out.print(res);

        br.close();
    }
}
