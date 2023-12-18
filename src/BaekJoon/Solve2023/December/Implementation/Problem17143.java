package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17143 {
    int row, col;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] field = new int[row][col];
        Map<Integer, Shark> map = new HashMap<>();
        for (int i = 1; i <= cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map.put(i, new Shark(x, y, s, d, z));
            field[x][y] = i;
        }

        int result = 0;
        for (int i = 0; i < col; i++) {
            //낚시
            for (int j = 0; j < row; j++) {
                if (field[j][i] > 0) {
                    int id = field[j][i];
                    result += map.get(id).z;
                    map.remove(id);
                    field[j][i] = 0;
                    break;
                }
            }
            //이동
            for (int key : map.keySet()) {
                Shark now = map.get(key);
                field[now.r][now.c] = 0;
                if (now.d == 1) {
                    if (move(now, -1, now.d) == 1) now.d = 2;
                } else if (now.d == 2) {
                    if (move(now, 1, now.d) == -1) now.d = 1;
                } else if (now.d == 3) {
                    if (move(now, 1, now.d) == -1) now.d = 4;
                } else {
                    if (move(now, -1, now.d) == 1) now.d = 3;
                }
            }

            List<Integer> removeList = new ArrayList<>();
            for (int key : map.keySet()) {
                Shark now = map.get(key);
                if (field[now.r][now.c] > 0) {
                    if (map.get(field[now.r][now.c]).z > now.z) {
                        removeList.add(key);
                    } else {
                        removeList.add(field[now.r][now.c]);
                        field[now.r][now.c] = key;
                    }
                } else {
                    field[now.r][now.c] = key;
                }
            }
            for (int key : removeList) {
                map.remove(key);
            }
        }
        System.out.print(result);

        br.close();
    }

    private int move(Shark shk, int d, int t) {
        int move = shk.s;
        while (move > 0) {
            if (t == 1 || t == 2) {
                if (shk.r == 0) d = 1;
                else if (shk.r == row - 1) d = -1;
                shk.r += d;
            } else {
                if (shk.c == 0) d = 1;
                else if (shk.c == col - 1) d = -1;
                shk.c += d;
            }
            move--;
        }
        return d;
    }

    class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
