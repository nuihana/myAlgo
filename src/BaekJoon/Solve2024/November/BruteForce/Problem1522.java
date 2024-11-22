package BaekJoon.Solve2024.November.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1522 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int aLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aLen++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int bCnt = 0;
            for (int j = i; j < aLen + i; j++) {
                if (s.charAt(j % s.length()) == 'b') bCnt++;
            }
            res = Math.min(res, bCnt);
        }
        System.out.print(res);

        br.close();
    }
}
