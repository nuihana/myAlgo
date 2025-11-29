package BaekJoon.Solve2025.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem32951 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(n - 2024);

        br.close();
    }
}
