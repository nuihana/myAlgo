package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1475 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int[] used = new int[10];
        for (int i = 0; i < src.length(); i++) {
            int now = src.charAt(i) - '0';
            used[now]++;
        }

        int sixnine = used[6] + used[9];
        int res = sixnine % 2 == 0 ? sixnine / 2 : sixnine / 2 + 1;
        for (int i = 0; i < used.length; i++) {
            if (i != 6 && i != 9) {
                res = Math.max(res, used[i]);
            }
        }

        System.out.print(res);

        br.close();
    }
}
