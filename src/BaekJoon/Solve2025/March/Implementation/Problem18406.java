package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem18406 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int left = 0, right = 0;
        for (int i = 0; i < src.length() / 2; i++) {
            int l = src.charAt(i) - '0';
            int r = src.charAt(src.length() - i - 1) - '0';

            left += l;
            right += r;
        }

        if (left == right) {
            System.out.print("LUCKY");
        } else {
            System.out.print("READY");
        }

        br.close();
    }
}
