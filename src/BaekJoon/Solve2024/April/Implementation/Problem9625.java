package BaekJoon.Solve2024.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9625 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;

        while (k-- > 0) {
            int tmp = b;
            b += a;
            a = tmp;
        }

        System.out.print(a + " " + b);

        br.close();
    }
}
