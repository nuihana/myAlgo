package BaekJoon.Solve2025.January.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1919 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String orgin = br.readLine();
        String another = br.readLine();

        int[] orgCnt = new int[26];
        int[] antCnt = new int[26];
        for (int i = 0; i < orgin.length(); i++) {
            char ch = orgin.charAt(i);
            orgCnt[ch - 'a']++;
        }
        for (int i = 0; i < another.length(); i++) {
            char ch = another.charAt(i);
            antCnt[ch - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(antCnt[i] - orgCnt[i]);
        }

        System.out.print(res);

        br.close();
    }
}
