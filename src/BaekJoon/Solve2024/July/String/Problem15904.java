package BaekJoon.Solve2024.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15904 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        char[] rst = new char[4];
        rst[0] = 'U';
        rst[1] = 'C';
        rst[2] = 'P';
        rst[3] = 'C';

        int res = 0;
        for (int i = 0; i < src.length() && res < 4; i++) {
            char c = src.charAt(i);

            if (c == rst[res]) {
                res++;
            }
        }

        if (res == 4) {
            System.out.print("I love UCPC");
        } else {
            System.out.print("I hate UCPC");
        }

        br.close();
    }
}
