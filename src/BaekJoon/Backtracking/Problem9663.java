package BaekJoon.Backtracking;

import java.io.*;

public class Problem9663 {
    private int count = 0;
    private int[] board = new int[15];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        trackingQueen(0, input);

        bw.write(Integer.toString(count));

        br.close();
        bw.close();
    }

    private void trackingQueen(int idx, int value) {
        if (idx == value) {
            count++;
            return;
        }

        for (int i = 0; i < value; i++) {
            board[idx] = i;
            if (isValid(idx)) {
                trackingQueen(idx + 1, value);
            }
        }
    }

    private boolean isValid(int idx) {
        for (int i = 0; i < idx; i++) {
            if (board[idx] == board[i] || idx - i == Math.abs(board[idx] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
