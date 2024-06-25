package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9657 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.print(n % 7 == 0 || n % 7 == 2 ? "CY" : "SK");

        br.close();
    }
}
