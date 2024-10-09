package BaekJoon.Solve2024.October.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1342 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] src = br.readLine().toCharArray();
        int[] flat = new int[27];
        for (int i = 0; i < src.length; i++) {
            flat[src[i] - 'a']++;
        }

        System.out.print(getCase(flat, 0, ' ', src.length));

        br.close();
    }

    private int getCase(int[] cnt, int depth, char pre, int len) {
        if (depth == len) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < 27; i++) {
            if (cnt[i] == 0) continue;

            char c = (char) (i + 'a');
            if (pre != c) {
                cnt[i]--;
                res += getCase(cnt, depth + 1, c, len);
                cnt[i]++;
            }
        }
        return res;
    }
}
