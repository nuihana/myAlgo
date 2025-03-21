package BaekJoon.Solve2025.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4299 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= sum / 2; i++) {
            int j = sum - i;

            if (j - i == diff) {
                System.out.print(j + " " + i);
                return;
            }
        }
        System.out.print("-1");

        br.close();
    }
}
