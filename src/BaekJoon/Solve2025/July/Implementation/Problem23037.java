package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem23037 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            int n = src.charAt(i) - '0';

            res += Math.pow(n, 5);
        }
        System.out.print(res);

        br.close();
    }
}
