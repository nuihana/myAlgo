package BaekJoon.Solve2024.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2607 {
    final int PATTERN_COUNT = 26;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCnt = Integer.parseInt(br.readLine());
        int[] src = getPattern(br.readLine());

        int res = 0;
        for (int i = 0; i < wordCnt - 1; i++) {
            int[] now = getPattern(br.readLine());

            if (isSimilar(src, now)) res++;
        }

        System.out.print(res);

        br.close();
    }

    private int[] getPattern(String str) {
        int[] res = new int[PATTERN_COUNT];
        for (int i = 0; i < str.length(); i++) {
            res[(str.charAt(i) - 'A')]++;
        }
        return res;
    }

    private boolean isSimilar(int[] a, int[] b) {
        int diff = 0;
        int aLen = 0;
        int bLen = 0;
        for (int i = 0; i < PATTERN_COUNT; i++) {
            diff += Math.abs(a[i] - b[i]);
            aLen += a[i];
            bLen += b[i];
        }

        return diff <= 2 && Math.abs(aLen - bLen) < 2;
    }
}
