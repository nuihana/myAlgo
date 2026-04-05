package BaekJoon.Solve2026.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6764 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        if (a > b && b > c && c > d) {
            System.out.print("Fish Diving");
        } else if (a < b && b < c && c < d) {
            System.out.print("Fish Rising");
        } else if (a == b && a == c && a == d) {
            System.out.print("Fish At Constant Depth");
        } else {
            System.out.print("No Fish");
        }

        br.close();
    }
}
