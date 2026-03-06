package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem19602 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int sum = s + m * 2 + l * 3;

        System.out.print(sum >= 10 ? "happy" : "sad");

        br.close();
    }
}
