package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem32929 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        if (x % 3 == 0) System.out.print("S");
        if (x % 3 == 1) System.out.print("U");
        if (x % 3 == 2) System.out.print("O");

        br.close();
    }
}
