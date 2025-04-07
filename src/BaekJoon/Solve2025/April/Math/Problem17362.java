package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17362 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int mod = (n - 1) % 8;
        if (mod == 0) {
            System.out.print("1");
        } else if (mod == 1 || mod == 7) {
            System.out.print("2");
        } else if (mod == 2 || mod == 6) {
            System.out.print("3");
        } else if (mod == 3 || mod == 5) {
            System.out.print("4");
        } else if (mod == 4) {
            System.out.print("5");
        }

        br.close();
    }
}
