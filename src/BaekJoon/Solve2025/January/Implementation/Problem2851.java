package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2851 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scores = new int[10];
        for (int i = 0; i < 10; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(100 - (res + scores[i])) <= Math.abs(100 - res)) {
                res += scores[i];
            } else {
                break;
            }
        }
        System.out.print(res);

        br.close();
    }
}
