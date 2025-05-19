package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2495 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String src = br.readLine();

            int max = 0;
            int stock = -1;
            int len = 0;
            for (int j = 0; j < src.length(); j++) {
                int num = src.charAt(j) - '0';

                if (num != stock) {
                    len = 1;
                    stock = num;
                } else {
                    len++;
                }

                max = Math.max(max, len);
            }

            System.out.println(max);
        }

        br.close();
    }
}
