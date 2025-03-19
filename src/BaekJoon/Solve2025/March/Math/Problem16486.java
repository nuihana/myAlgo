package BaekJoon.Solve2025.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem16486 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        double pie = 3.141592;

        System.out.print(pie * 2 * d2 + 4 * d2 + 2 * d1);

        br.close();
    }
}
