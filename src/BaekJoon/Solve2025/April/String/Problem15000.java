package BaekJoon.Solve2025.April.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15000 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lower = br.readLine();
        System.out.print(lower.toUpperCase());

        br.close();
    }
}
