package BaekJoon.Solve2025.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        int sum = r * 8 + s * 3;

        System.out.print(Math.max(0, sum - 28));

        br.close();
    }
}
