package BaekJoon.Solve2025.January.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10987 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                res++;
            }
        }
        System.out.print(res);

        br.close();
    }
}
