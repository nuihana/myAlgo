package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17070 {
    int houseSize;
    int[][] house;
    int ans;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        houseSize = Integer.parseInt(br.readLine());
        house = new int[houseSize + 1][houseSize + 1];
        for (int i = 1; i <= houseSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= houseSize; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        dfs(1, 2, 0);

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
    
    private void dfs(int x, int y, int direction) {
        if (x == houseSize && y == houseSize) {
            ans++;
            return;
        }
        
        if (direction == 0) {
            if (y + 1 <= houseSize && house[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }
        } else if (direction == 1) {
            if (x + 1 <= houseSize && house[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        } else if (direction == 2) {
            if (y + 1 <= houseSize && house[x][y + 1] == 0) {
                dfs(x, y + 1, 0);
            }

            if (x + 1 <= houseSize && house[x + 1][y] == 0) {
                dfs(x + 1, y, 1);
            }
        }

        if (y + 1 <= houseSize && x + 1 <= houseSize
                && house[x][y + 1] == 0 && house[x + 1][y] == 0 && house[x + 1][y + 1] == 0) {
            dfs(x + 1, y + 1, 2);
        }
    }
}
