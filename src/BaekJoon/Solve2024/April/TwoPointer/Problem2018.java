package BaekJoon.Solve2024.April.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2018 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());
        long l = 0;
        long r = 1;
        long val = 0;
        int res = 0;
        while (l < r) {
            if (num == val) {
                res++;
                val += ++r;
                continue;
            }

            if (num > val) val += ++r;
            else val -= ++l;
        }

        System.out.print(res);

        br.close();
    }
}
