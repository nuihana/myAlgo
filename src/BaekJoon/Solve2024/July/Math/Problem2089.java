package BaekJoon.Solve2024.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2089 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if (n == 0) {
            sb.append(0);
        } else {
            while (n != 1) {
                sb.append(Math.abs(n % -2));

                n = (int) Math.ceil((double) n / -2);
            }
            sb.append(n);
        }

        System.out.print(sb.reverse());

        br.close();
    }
}
