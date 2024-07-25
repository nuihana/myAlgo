package BaekJoon.Solve2024.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14490 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String[] spl = src.split(":");

        int a = Integer.parseInt(spl[0]);
        int b = Integer.parseInt(spl[1]);
        int gcd = a > b ? GCD(a, b) : GCD(b, a);

        System.out.print((a / gcd) + ":" + (b / gcd));

        br.close();
    }

    private int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
}
