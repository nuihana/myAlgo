package BaekJoon.Solve2023.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15683 {
    int height;
    int width;
    List<int[]> camList = new ArrayList<>(); // 0 : x, 1 : y, 2 : 종류

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        int[][] arr = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0 && arr[i][j] < 6) camList.add(new int[]{ i, j, arr[i][j] });
            }
        }

        System.out.print(getMaxRange(0, arr));

        br.close();
    }

    private int getMaxRange(int idx, int[][] field) {
        if (idx == camList.size()) {
            int res = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] == 0) res++;
                }
            }
            return res;
        }

        int[] now = camList.get(idx);
        int[][] next = new int[height][width];
        for (int i = 0; i < height; i++) {
            System.arraycopy(field[i], 0, next[i], 0, field[i].length);
        }

        int res = Integer.MAX_VALUE;
        if (now[2] == 1) {
            //상
            setCam(now[0], now[1], idx + 8, 0, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 0, next);
            //우
            setCam(now[0], now[1], idx + 8, 1, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 1, next);
            //하
            setCam(now[0], now[1], idx + 8, 2, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 2, next);
            //좌
            setCam(now[0], now[1], idx + 8, 3, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 3, next);
        } else if (now[2] == 2) {
            //좌우
            setCam(now[0], now[1], idx + 8, 1, next);
            setCam(now[0], now[1], idx + 8, 3, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 1, next);
            resetCam(now[0], now[1], idx + 8, 3, next);
            //상하
            setCam(now[0], now[1], idx + 8, 0, next);
            setCam(now[0], now[1], idx + 8, 2, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 0, next);
            resetCam(now[0], now[1], idx + 8, 2, next);
        } else if (now[2] == 3) {
            //상우
            setCam(now[0], now[1], idx + 8, 0, next);
            setCam(now[0], now[1], idx + 8, 1, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 0, next);
            resetCam(now[0], now[1], idx + 8, 1, next);
            //우하
            setCam(now[0], now[1], idx + 8, 1, next);
            setCam(now[0], now[1], idx + 8, 2, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 1, next);
            resetCam(now[0], now[1], idx + 8, 2, next);
            //하좌
            setCam(now[0], now[1], idx + 8, 2, next);
            setCam(now[0], now[1], idx + 8, 3, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 2, next);
            resetCam(now[0], now[1], idx + 8, 3, next);
            //좌상
            setCam(now[0], now[1], idx + 8, 3, next);
            setCam(now[0], now[1], idx + 8, 0, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 3, next);
            resetCam(now[0], now[1], idx + 8, 0, next);
        } else if (now[2] == 4) {
            //좌상우
            setCam(now[0], now[1], idx + 8, 3, next);
            setCam(now[0], now[1], idx + 8, 0, next);
            setCam(now[0], now[1], idx + 8, 1, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 3, next);
            resetCam(now[0], now[1], idx + 8, 0, next);
            resetCam(now[0], now[1], idx + 8, 1, next);
            //상우하
            setCam(now[0], now[1], idx + 8, 0, next);
            setCam(now[0], now[1], idx + 8, 1, next);
            setCam(now[0], now[1], idx + 8, 2, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 0, next);
            resetCam(now[0], now[1], idx + 8, 1, next);
            resetCam(now[0], now[1], idx + 8, 2, next);
            //우하좌
            setCam(now[0], now[1], idx + 8, 1, next);
            setCam(now[0], now[1], idx + 8, 2, next);
            setCam(now[0], now[1], idx + 8, 3, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 1, next);
            resetCam(now[0], now[1], idx + 8, 2, next);
            resetCam(now[0], now[1], idx + 8, 3, next);
            //하좌상
            setCam(now[0], now[1], idx + 8, 2, next);
            setCam(now[0], now[1], idx + 8, 3, next);
            setCam(now[0], now[1], idx + 8, 0, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
            resetCam(now[0], now[1], idx + 8, 2, next);
            resetCam(now[0], now[1], idx + 8, 3, next);
            resetCam(now[0], now[1], idx + 8, 0, next);
        } else if (now[2] == 5) {
            setCam(now[0], now[1], 20, 0, next);
            setCam(now[0], now[1], 20, 1, next);
            setCam(now[0], now[1], 20, 2, next);
            setCam(now[0], now[1], 20, 3, next);
            res = Math.min(res, getMaxRange(idx + 1, next));
        }

        return res;
    }

    private void setCam(int x, int y, int mark, int direction, int[][] field) {
        if (direction == 0) { // 위 방향
            for (int i = x - 1; i >= 0; i--) {
                if (field[i][y] == 6) break;
                if (field[i][y] == 0) field[i][y] = mark;
            }
        } else if (direction == 1) { //오른쪽 방향
            for (int j = y + 1; j < width; j++) {
                if (field[x][j] == 6) break;
                if (field[x][j] == 0) field[x][j] = mark;
            }
        } else if (direction == 2) { //아래 방향
            for (int i = x + 1; i < height; i++) {
                if (field[i][y] == 6) break;
                if (field[i][y] == 0) field[i][y] = mark;
            }
        } else if (direction == 3) { //왼쪽 방향
            for (int j = y - 1; j >= 0; j--) {
                if (field[x][j] == 6) break;
                if (field[x][j] == 0) field[x][j] = mark;
            }
        }
    }

    private void resetCam(int x, int y, int mark, int direction, int[][] field) {
        if (direction == 0) { // 위 방향
            for (int i = x - 1; i >= 0; i--) {
                if (field[i][y] == 6) break;
                if (field[i][y] == mark) field[i][y] = 0;
            }
        } else if (direction == 1) { //오른쪽 방향
            for (int j = y + 1; j < width; j++) {
                if (field[x][j] == 6) break;
                if (field[x][j] == mark) field[x][j] = 0;
            }
        } else if (direction == 2) { //아래 방향
            for (int i = x + 1; i < height; i++) {
                if (field[i][y] == 6) break;
                if (field[i][y] == mark) field[i][y] = 0;
            }
        } else if (direction == 3) { //왼쪽 방향
            for (int j = y - 1; j >= 0; j--) {
                if (field[x][j] == 6) break;
                if (field[x][j] == mark) field[x][j] = 0;
            }
        }
    }
}
