package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5543 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = -50;
        int min = 2001;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, Integer.parseInt(br.readLine()));
        }
        res += min;
        min = 2001;
        for (int i = 0; i < 2; i++) {
            min = Math.min(min, Integer.parseInt(br.readLine()));
        }
        res += min;
        System.out.print(res);

        br.close();
    }
}
