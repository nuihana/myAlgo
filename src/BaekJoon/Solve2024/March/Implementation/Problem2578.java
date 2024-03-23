package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem2578 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                pos.put(board[i][j], i * 5 + j);
            }
        }

        int turn = 0;
        boolean[][] chk = new boolean[5][5];
        boolean done = false;
        for (int i = 0; i < 5 && !done; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 && !done; j++) {
                turn++;
                int call = Integer.parseInt(st.nextToken());

                int cx = pos.get(call) / 5;
                int cy = pos.get(call) % 5;
                chk[cx][cy] = true;

                if (isBingo(chk)) {
                    done = true;
                }
            }
        }

        System.out.print(turn);

        br.close();
    }

    private boolean isBingo(boolean[][] chk) {
        int bingoCnt = 0;
        //가로
        for (int i = 0; i < 5; i++) {
            int done = 0;
            for (int j = 0; j < 5; j++) {
                if (chk[i][j]) done++;
                else break;
            }
            if (done == 5) bingoCnt++;
        }
        //세로
        for (int i = 0; i < 5; i++) {
            int done = 0;
            for (int j = 0; j < 5; j++) {
                if (chk[j][i]) done++;
                else break;
            }
            if (done == 5) bingoCnt++;
        }
        //대각선
        int ltrb = 0;
        for (int i = 0; i < 5; i++) {
            if (chk[i][i]) ltrb++;
        }
        if (ltrb == 5) bingoCnt++;
        int lbrt = 0;
        for (int i = 0; i < 5; i++) {
            if (chk[i][4 - i]) lbrt++;
        }
        if (lbrt == 5) bingoCnt++;

        return bingoCnt >= 3;
    }
}
