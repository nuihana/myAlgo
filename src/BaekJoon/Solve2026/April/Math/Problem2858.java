package BaekJoon.Solve2026.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2858 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int i = 3, size = r + b;
        while (true) {
            if (size % i == 0) {
                if ((i - 2) * (size / i - 2) == b) {
                    System.out.print(Math.max(i, size / i) + " " + Math.min(i, size / i));
                    break;
                }
            }
            i++;
        }

        br.close();
    }
}
