package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24883 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        if (in.equalsIgnoreCase("N")) {
            System.out.print("Naver D2");
        } else {
            System.out.print("Naver Whale");
        }

        br.close();
    }
}
