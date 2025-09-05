package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13985 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int a = src.charAt(0) - '0';
        int b = src.charAt(4) - '0';
        int c = src.charAt(8) - '0';
        if (a + b == c) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        br.close();
    }
}
