package BaekJoon.Solve2023.June.CP_BruteForce_Recursive;

import java.io.*;
import java.util.StringTokenizer;

public class Problem4574 {
    int[][] field;
    boolean[][] dominoes;
    int[] dx = {1, 0};
    int[] dy = {0, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        while(true) {
            int dominoCnt = Integer.parseInt(br.readLine());

            if (dominoCnt == 0) break;

            field = new int[9][9];
            dominoes = new boolean[10][10];
            for (int i = 0; i < dominoCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                String idx_a = st.nextToken();
                setDomino(a, idx_a);

                int b = Integer.parseInt(st.nextToken());
                String idx_b = st.nextToken();
                setDomino(b, idx_b);

                dominoes[a][b] = true;
                dominoes[b][a] = true;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                setDomino(i + 1, st.nextToken());
            }

            solve(0);

            bw.write("Puzzle " + idx);
            bw.newLine();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(String.valueOf(field[i][j]));
                }
                bw.newLine();
            }
            idx++;
        }

        br.close();
        bw.close();
    }

    private void setDomino(int val, String idx) {
        int x = idx.charAt(0) - 65;
        int y = idx.charAt(1) - 49;

        field[x][y] = val;
    }

    private boolean solve(int pos) {
        if (pos == 81) return true;

        int x = pos / 9;
        int y = pos % 9;

        if(field[x][y] == 0) {
            for (int k = 0; k < 2; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || nx >= 9 || ny < 0 || ny >= 9 || field[nx][ny] != 0) continue;

                for (int i = 1; i <= 9; i++) {
                    for (int j = 1; j <= 9; j++) {
                        if (i == j || dominoes[i][j]) continue;

                        if (chk(x, y, i) && chk(nx, ny, j)) {
                            field[x][y] = i;
                            field[nx][ny] = j;

                            dominoes[i][j] = true;
                            dominoes[j][i] = true;

                            if(solve(pos + 1)) return true;

                            dominoes[i][j] = false;
                            dominoes[j][i] = false;

                            field[x][y] = 0;
                            field[nx][ny] = 0;
                        }
                    }
                }
            }
        } else {
            return solve(pos + 1);
        }

        return false;
    }

    private boolean chk(int x, int y, int n) {
        int row = 0;
        int col = 0;

        for (; row < 9; row++) {
            if (field[row][y] == n) return false;
        }

        for (; col < 9; col++) {
            if (field[x][col] == n) return false;
        }

        row = (x / 3) * 3;
        col = (y / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (field[i][j] == n) return false;
            }
        }
        return true;
    }
}
