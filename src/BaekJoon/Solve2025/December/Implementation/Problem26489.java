package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem26489 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;
        while (true) {
            String src = br.readLine();
            if (src == null || src.isEmpty()) break;

            res++;
        }
        System.out.print(res);

        br.close();
    }
}
