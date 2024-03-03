package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem20056 {
    List<Fireball>[][] field;
    List<Fireball> fbList;
    int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int fbCnt = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        field = new List[size][size];
        fbList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < fbCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            fbList.add(new Fireball(row, col, mass, speed, direction));
        }

        while (time-- > 0) {
            moveFB(size);
            splitFB(size);
        }

        System.out.print(getMassSum());

        br.close();
    }

    private void moveFB(int size) {
        for (Fireball now : fbList) {
            int nx = (now.x + size + dx[now.direction] * (now.speed % size)) % size;
            int ny = (now.y + size + dy[now.direction] * (now.speed % size)) % size;
            now.x = nx;
            now.y = ny;
            field[nx][ny].add(now);
        }
    }

    private void splitFB(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j].size() < 2) {
                    field[i][j].clear();
                    continue;
                }

                int massSum = 0, speedSum = 0, oddCnt = 0, evenCnt = 0;
                int cnt = field[i][j].size();
                for (Fireball fb : field[i][j]) {
                    massSum += fb.mass;
                    speedSum += fb.speed;
                    if (fb.direction % 2 == 1) oddCnt++;
                    else evenCnt++;
                    fbList.remove(fb);
                }
                field[i][j].clear();
                massSum /= 5;
                if (massSum == 0) continue;
                speedSum /= cnt;
                if (oddCnt == cnt || evenCnt == cnt) {
                    for (int k = 0; k < 8; k+=2) fbList.add(new Fireball(i, j, massSum, speedSum, k));
                } else {
                    for (int k = 1; k < 8; k+=2) fbList.add(new Fireball(i, j, massSum, speedSum, k));
                }
            }
        }
    }

    private int getMassSum() {
        int result = 0;
        for (Fireball now : fbList) result += now.mass;
        return result;
    }

    class Fireball {
        int x, y, mass, speed, direction;

        public Fireball(int r, int c, int m, int s, int d) {
            x = r;
            y = c;
            mass = m;
            speed = s;
            direction = d;
        }
    }
}
