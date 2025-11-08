package BaekJoon.Solve2025.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8871 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(((n + 1) * 2) + " " + ((n + 1) * 3));

        br.close();
    }
}
