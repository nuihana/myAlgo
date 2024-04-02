package BaekJoon.Solve2024.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1850 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if (a > b) {
            System.out.print("1".repeat(GCD(a, b)));
        } else if (a < b) {
            System.out.print("1".repeat(GCD(b, a)));
        } else {
            System.out.print("1".repeat((int) a));
        }

        br.close();
    }

    private int GCD(long a, long b) {
        if (a % b == 0) return (int) b;
        return GCD(b, a % b);
    }
}
