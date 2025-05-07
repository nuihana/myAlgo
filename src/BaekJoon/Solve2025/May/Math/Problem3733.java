package BaekJoon.Solve2025.May.Math;

import java.io.IOException;
import java.util.Scanner;

public class Problem3733 {
    public void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int n, s;
        while (sc.hasNext()) {
            n = sc.nextInt();
            s = sc.nextInt();
            System.out.println(s / (n + 1));
        }
    }
}
