package BaekJoon.Solve2025.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11283 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char src = br.readLine().charAt(0);
        System.out.print((int) src - 44031);

        br.close();
    }
}
