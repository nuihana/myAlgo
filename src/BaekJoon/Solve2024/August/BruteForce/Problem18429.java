package BaekJoon.Solve2024.August.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18429 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] up = new int[day];
        for (int i = 0; i < day; i++) {
            up[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isUsed = new boolean[day];
        System.out.print(getCase(up, isUsed, down, 0));

        br.close();
    }

    private int getCase(int[] up, boolean[] isUsed, int down, int now) {
        if (now < 0) return 0;
        if (isDone(isUsed)) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < up.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                res += getCase(up, isUsed, down, now + up[i] - down);
                isUsed[i] = false;
            }
        }

        return res;
    }

    private boolean isDone(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) return false;
        }
        return true;
    }
}
