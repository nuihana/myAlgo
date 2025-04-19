package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25238 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if ((double) a - ((double) a / 100 * b) >= 100) {
            System.out.print(0);
        } else {
            System.out.print(1);
        }

        br.close();
    }
}
