package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem27324 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        if (src.charAt(0) == src.charAt(1)) System.out.print(1);
        else System.out.print(0);

        br.close();
    }
}
