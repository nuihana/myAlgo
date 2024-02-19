package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem17136 {
    int[][] paper;
    int[] stock = { 0, 5, 5, 5, 5, 5 };
    int ans = Integer.MAX_VALUE;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = 10;
        paper = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.print(ans);

        br.close();
    }

    private void dfs(int x, int y, int cnt) {
        if (x >= 9 && y > 9) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (ans <= cnt) return;

        if (y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (paper[x][y] == 1) {
            for (int i = 5; i > 0; i--) {
                if (stock[i] > 0 && isAttachable(x, y, i)) {
                    attach(x, y, i, 0);
                    stock[i]--;
                    dfs(x, y + 1, cnt + 1);
                    attach(x, y, i, 1);
                    stock[i]++;
                }
            }
        } else {
            dfs(x, y + 1, cnt);
        }
    }

    private void attach(int x, int y, int size, int state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                paper[i][j] = state;
            }
        }
    }

    private boolean isAttachable(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) return false;
                if (paper[i][j] != 1) return false;
            }
        }
        return true;
    }
}
