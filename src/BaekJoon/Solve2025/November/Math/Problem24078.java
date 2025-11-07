package BaekJoon.Solve2025.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24078 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        System.out.print(x % 21);

        br.close();
    }
}
