package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2959 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sqr = new int[4];
        for (int i = 0; i < 4; i++) {
            sqr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sqr);

        System.out.print(sqr[0] * sqr[2]);

        br.close();
    }
}
