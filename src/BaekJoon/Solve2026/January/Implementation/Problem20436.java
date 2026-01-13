package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem20436 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] posX = { 0, 4, 2, 2, 2, 3, 4, 5, 7, 6, 7, 8, 6, 5, 8, 9, 0, 3, 1, 4, 6, 3, 1, 1, 5, 0 };
        int[] posY = { 1, 0, 0, 1, 2, 1, 1, 1, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2, 1, 2, 2, 0, 2, 0, 2, 0 };

        StringTokenizer st = new StringTokenizer(br.readLine());
        char l = st.nextToken().charAt(0);
        char r = st.nextToken().charAt(0);

        String src = br.readLine();
        int res = 0;
        for (char c : src.toCharArray()) {
            if (isLeftHand(c)) {
                res += getDistance(l, c, posX, posY);
                l = c;
            } else {
                res += getDistance(r, c, posX, posY);
                r = c;
            }
            res++;
        }
        System.out.print(res);

        br.close();
    }

    private int getDistance(char s, char e, int[] posX, int[] posY) {
        return Math.abs(posX[s - 'a'] - posX[e - 'a']) + Math.abs(posY[s - 'a'] - posY[e - 'a']);
    }

    private boolean isLeftHand(char c) {
        char[] leftChar = { 'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v' };
        for (char l : leftChar) {
            if (l == c) return true;
        }
        return false;
    }
}
