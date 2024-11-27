package BaekJoon.Solve2024.November.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2992 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = findMin(src, 0, 0, new boolean[src.length()]);

        System.out.print(res == 1000000 ? 0 : res);

        br.close();
    }

    private int findMin(String src, int num, int idx, boolean[] isUsed) {
        if (src.length() == idx) {
            if (Integer.parseInt(src) < num) return num;
            else return 1000000;
        }

        int res = 1000000;
        for (int i = 0; i < src.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                int n = src.charAt(i) - '0';
                res = Math.min(res, findMin(src, num * 10 + n, idx + 1, isUsed));
                isUsed[i] = false;
            }
        }
        return res;
    }
}
