package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3028 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 1;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == 'A') {
                if (res == 1) res = 2;
                else if (res == 2) res = 1;
            } else if (c == 'B') {
                if (res == 2) res = 3;
                else if (res == 3) res = 2;
            } else if (c == 'C') {
                if (res == 1) res = 3;
                else if (res == 3) res = 1;
            }
        }
        System.out.print(res);

        br.close();
    }
}
