package BaekJoon.Solve2024.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1977 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());

        int minPow = Integer.MAX_VALUE;
        int powSum = 0;

        int start = 1;
        while (start * start < min) start++;

        while (start * start <= max) {
            minPow = Math.min(minPow, start * start);
            powSum += start * start;
            start++;
        }

        if (minPow == Integer.MAX_VALUE) {
            System.out.print("-1");
        } else {
            System.out.println(powSum);
            System.out.print(minPow);
        }

        br.close();
    }
}
