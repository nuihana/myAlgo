package BaekJoon.Solve2025.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem16916 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        System.out.print(KMP(s, p));

        br.close();
    }

    private int[] makeTable(String pattern) {
        int len = pattern.length();
        int[] table = new int[len];

        int idx = 0;
        for (int i = 1; i < len; i++) {
            while (idx > 0 && pattern.charAt(idx) != pattern.charAt(i)) {
                idx = table[idx - 1];
            }

            if (pattern.charAt(idx) == pattern.charAt(i)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

    private int KMP(String a, String b) {
        int[] table = makeTable(b);

        int aLen = a.length(), bLen = b.length();

        int idx = 0;
        for (int i = 0; i < aLen; i++) {
            while (idx > 0 && a.charAt(i) != b.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (a.charAt(i) == b.charAt(idx)) {
                if (idx == bLen - 1) {
                    return 1;
                } else {
                    idx += 1;
                }
            }
        }
        return 0;
    }
}
