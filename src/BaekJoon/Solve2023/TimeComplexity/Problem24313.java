package BaekJoon.Solve2023.TimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem24313 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int a0 = Integer.parseInt(br.readLine());

        double flag = c - a1 == 0 ? a2 : (double) a2 / (c - a1);

        if ((c - a1) >= 0 && flag <= a0) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }

        br.close();
    }
}
