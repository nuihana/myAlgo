package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem20057 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = size / 2;
        int y = size / 2;
        int move = 1;
        int direction = 0; // 0 : 왼, 1 : 아, 2 : 오, 3 : 위
        int res = 0;
        while (true) {
            if (move == size) {
                while (y > 0) {
                    y--;
                    res += tornado(arr, x, y, 0);
                }
                break;
            }

            for (int i = 1; i <= move; i++) {
                y += (direction == 0 || direction == 3 ? - 1 : 1);
                res += tornado(arr, x, y, direction);
            }
            direction++;

            for (int i = 1; i <= move; i++) {
                x += (direction == 0 || direction == 3 ? - 1 : 1);
                res += tornado(arr, x, y, direction);
            }
            direction = (direction + 1) % 4;
            move++;
        }

        System.out.print(res);

        br.close();
    }

    private int tornado(int[][] arr, int x, int y, int direction) {
        int amount = arr[x][y];
        arr[x][y] = 0;

        int[][] dx = {
                { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 },
                { 2, 1, 1, 0, 0, 0, 0, -1, -1, 1 },
                { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 },
                { -2, -1, -1, 0, 0, 0, 0, 1, 1, -1 }
        };
        int[][] dy = {
                { -2, -1, -1, 0, 0, 0, 0, 1, 1, -1 },
                { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 },
                { 2, 1, 1, 0, 0, 0, 0, -1, -1, 1 },
                { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 }
        };
        int[] da = { 5, 10, 10, 2, 7, 7, 2, 1, 1 };

        int out = 0;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int nx = x + dx[direction][i];
            int ny = y + dy[direction][i];

            if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length) {
                out += amount * da[i] / 100;
                sum += amount * da[i] / 100;
                continue;
            }

            arr[nx][ny] += amount * da[i] / 100;
            sum += amount * da[i] / 100;
        }

        int nx = x + dx[direction][9];
        int ny = y + dy[direction][9];
        if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr.length) {
            out += amount - sum;
        } else {
            arr[nx][ny] += amount - sum;
        }

        return out;
    }
}
