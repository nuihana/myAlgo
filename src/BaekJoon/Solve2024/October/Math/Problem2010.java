package BaekJoon.Solve2024.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2010 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            sum += Integer.parseInt(br.readLine());
            sum--;
        }
        System.out.print(sum);

        br.close();
    }
}
