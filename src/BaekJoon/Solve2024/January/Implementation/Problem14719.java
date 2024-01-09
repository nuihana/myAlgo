package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14719 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] field = new int[row][col];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < col; j++) {
            int wall = Integer.parseInt(st.nextToken());
            for (int i = 0; i < wall; i++) {
                field[i][j] = 1;
            }
        }

        //왼쪽 벽
        for (int i = 0; i < row; i++) {
            if (field[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    if (field[i][j] == 0) field[i][j] = 2;
                    else break;
                }
            }
        }
        //오른쪽 벽
        for (int i = 0; i < row; i++) {
            if (field[i][col - 1] == 0) {
                for (int j = col - 1; j >= 0; j--) {
                    if (field[i][j] == 0) field[i][j] = 2;
                    else break;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (field[i][j] == 0) res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
