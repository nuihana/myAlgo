package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1598 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int height = Math.abs(a % 4 - b % 4);
        int width = Math.abs(a / 4 - b / 4);

        System.out.print(height + width);

        br.close();
    }
}
