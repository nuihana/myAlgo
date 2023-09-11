package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Problem3109 {
    int r, c;
    int[][] field;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        field = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = line.charAt(j);
                if (ch == '.') field[i][j] = 0;
                if (ch == 'x') field[i][j] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            if (chk(i, 0)) res++;
        }
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private boolean chk(int x, int y) {
        field[x][y] = 2;

        if (y == c - 1) return true;
        if (x > 0 && field[x - 1][y + 1] == 0) {
            if (chk(x - 1, y + 1)) return true;
        }
        if (field[x][y + 1] == 0) {
            if (chk(x, y + 1)) return true;
        }
        if (x + 1 < r && field[x + 1][y + 1] == 0) {
            if (chk(x + 1, y + 1)) return true;
        }
        return false;
    }
}
