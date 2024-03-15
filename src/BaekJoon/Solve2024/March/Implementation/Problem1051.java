package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1051 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int maxSize = Math.min(row, col);

        int res = 0;
        for (int size = 0; size < maxSize; size++) {
            boolean isExist = false;
            for (int i = 0; i < row - size && !isExist; i++) {
                for (int j = 0; j < col - size && !isExist; j++) {
                    if (arr[i][j] == arr[i][j + size] && arr[i][j] == arr[i + size][j] && arr[i][j] == arr[i + size][j + size]) {
                        isExist = true;
                    }
                }
            }

            if (isExist) res = size + 1;
        }

        System.out.print(res * res);

        br.close();
    }
}
