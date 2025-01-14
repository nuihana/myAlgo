package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20492 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print((n / 100 * 78) + " " + (n / 1000 * 956));

        br.close();
    }
}
