package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20499 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] kda = br.readLine().split("/");

        int k = Integer.parseInt(kda[0]);
        int d = Integer.parseInt(kda[1]);
        int a = Integer.parseInt(kda[2]);

        if (k + a < d || d == 0) {
            System.out.print("hasu");
        } else {
            System.out.print("gosu");
        }

        br.close();
    }
}
