package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1331 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String now = br.readLine();
        String first = now;
        boolean[][] isVisit = new boolean[6][6];
        int[] nowIdx = getIdx(now);
        isVisit[nowIdx[0]][nowIdx[1]] = true;
        int n = 35;
        boolean result = true;
        while (n-- > 0) {
            String next = br.readLine();
            int[] nextIdx = getIdx(next);
            if (!isValid(now, next) || isVisit[nextIdx[0]][nextIdx[1]]) {
                result = false;
                break;
            }
            isVisit[nextIdx[0]][nextIdx[1]] = true;
            now = next;
        }

        if (result && isValid(now, first)) {
            System.out.print("Valid");
        } else {
            System.out.print("Invalid");
        }

        br.close();
    }

    private boolean isValid(String before, String after) {
        int width = Math.abs(after.charAt(0) - before.charAt(0));
        int height = Math.abs(after.charAt(1) - before.charAt(1));

        if (width == 2) {
            return height == 1;
        } else if (width == 1) {
            return height == 2;
        } else {
            return false;
        }
    }

    private int[] getIdx(String src) {
        return new int[]{ src.charAt(0) - 'A', src.charAt(1) - '1' };
    }
}
