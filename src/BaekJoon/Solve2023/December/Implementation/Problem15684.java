package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15684 {
    boolean[][] ladders;
    int n, m, h, ans = 4;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladders = new boolean[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            ladders[row][col] = true;
        }

        addLadder(0, 1, 1);
        ans = ans == 4 ? -1 : ans;
        System.out.print(ans);

        br.close();
    }

    private void addLadder(int cnt, int y, int x) {
        boolean init = false;
        if (cnt >= ans) return;
        if (chk()) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (!init) {
                    i = y;
                    j = x;
                    init = true;
                    if (j >= n) continue;
                }
                if (ladders[i][j] || ladders[i][j - 1] || ladders[i][j + 1]) continue;
                ladders[i][j] = true;
                addLadder(cnt + 1, i, j + 1);
                ladders[i][j] = false;
            }
        }
    }

    private boolean chk() {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (ladders[i][j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] != i) return false;
        }
        return true;
    }
}
