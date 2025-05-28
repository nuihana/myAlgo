package BaekJoon.Solve2025.May.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17496 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        System.out.print((n - 1) / t * c * p);

        br.close();
    }
}
