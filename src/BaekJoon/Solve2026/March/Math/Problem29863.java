package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem29863 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sleep = Integer.parseInt(br.readLine());
        int awake = Integer.parseInt(br.readLine());

        if (sleep > 12) {
            System.out.print(awake + 24 - sleep);
        } else {
            System.out.print(awake - sleep);
        }

        br.close();
    }
}
