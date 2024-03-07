package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1543 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] src = br.readLine().toCharArray();
        char[] search = br.readLine().toCharArray();

        int res = 0;
        for (int i = 0; i < src.length - search.length + 1; i++) {
            boolean isSame = true;
            for (int j = 0; j < search.length; j++) {
                if (src[i + j] != search[j]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) res++;
        }

        System.out.print(res);

        br.close();
    }
}
