package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17406 {
    int row, col, cmd, res = Integer.MAX_VALUE;
    int[][] map, cycle;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        cmd = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[cmd][3];
        for (int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());
            cycle[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][1] = Integer.parseInt(st.nextToken()) - 1;
            cycle[i][2] = Integer.parseInt(st.nextToken());
        }

        search(0, new int[cmd], new boolean[cmd]);
        System.out.print(res);

        br.close();
    }

    private void search(int cnt, int[] arr, boolean[] visited) {
        if (cnt == cmd) {
            doCycle(arr);
            return;
        }
        for (int i = 0; i < cmd; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            search(cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    private void doCycle(int[] arr) {
        int[][] tmp = copyArr();

        for (int k = 0; k < cmd; k++) {
            int r = cycle[arr[k]][0];
            int c = cycle[arr[k]][1];
            int S = cycle[arr[k]][2];

            for (int s = 1; s <= S; s++) {
                int upTmp = tmp[r - s][c + s];
                for (int y = c + s; y > c - s; y--) {
                    tmp[r - s][y] = tmp[r - s][y - 1];
                }
                int rightTmp = tmp[r+s][c+s];
                for(int x = r+s; x > r-s; x--) {
                    tmp[x][c+s] = tmp[x-1][c+s];
                }
                tmp[r-s+1][c+s] = upTmp;
                int leftTmp = tmp[r+s][c-s];
                for(int y = c-s; y < c+s; y++) {
                    tmp[r+s][y] = tmp[r+s][y+1];
                }
                tmp[r+s][c+s-1] = rightTmp;
                for(int x = r-s; x < r+s; x++) {
                    tmp[x][c-s] = tmp[x+1][c-s];
                }
                tmp[r+s-1][c-s] = leftTmp;
            }
        }

        getAnswer(tmp);
    }

    public int[][] copyArr() {
        int[][] tmp = new int[row][col];

        for (int i = 0; i < row; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0, col);
        }

        return tmp;
    }

    private void getAnswer(int[][] tmp) {
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += tmp[i][j];
            }
            res = Math.min(res, sum);
        }
    }
}
