package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15873 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        if (src.length() == 2) {
            int a = Integer.parseInt(src.substring(0, 1));
            int b = Integer.parseInt(src.substring(1, 2));

            System.out.print(a + b);
        } else if (src.length() == 3) {
            if (src.indexOf("0") > 1) {
                int a = Integer.parseInt(src.substring(0, 1));
                int b = Integer.parseInt(src.substring(1, 3));

                System.out.print(a + b);
            } else {
                int a = Integer.parseInt(src.substring(0, 2));
                int b = Integer.parseInt(src.substring(2, 3));

                System.out.print(a + b);
            }
        } else {
            int a = Integer.parseInt(src.substring(0, 2));
            int b = Integer.parseInt(src.substring(2, 4));

            System.out.print(a + b);
        }

        br.close();
    }
}
