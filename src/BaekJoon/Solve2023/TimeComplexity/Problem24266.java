package BaekJoon.Solve2023.TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24266 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long size = Integer.parseInt(br.readLine());

        System.out.println(size * size * size);
        System.out.print("3");

        br.close();
    }
}
