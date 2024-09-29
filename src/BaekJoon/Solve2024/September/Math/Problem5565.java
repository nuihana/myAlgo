package BaekJoon.Solve2024.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5565 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            total -= Integer.parseInt(br.readLine());
        }
        System.out.print(total);

        br.close();
    }
}
