package BaekJoon.Solve2025.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem29699 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n = (n - 1) % 14;

        String src = "WelcomeToSMUPC";
        System.out.print(src.charAt(n));

        br.close();
    }
}
