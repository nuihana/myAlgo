package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17614 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = 0;
        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            int now = i;
            while (now > 0) {
                if (now % 10 == 3 || now % 10 == 6 || now % 10 == 9) res++;
                now /= 10;
            }
        }

        System.out.print(res);

        br.close();
    }
}
