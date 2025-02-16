package BaekJoon.Solve2025.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5598 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            int idx = c - 3;

            if (idx >= 65) {
                System.out.print((char) idx);
            } else {
                System.out.print((char) (idx + 26));
            }
        }

        br.close();
    }
}
