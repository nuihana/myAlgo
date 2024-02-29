package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem19236 {
    int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
    int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[4][4];
        List<Fish> fishList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishList.add(new Fish(i, j, idx, dir, true));
                arr[i][j] = idx;
            }
        }

        fishList.sort(Comparator.comparingInt(o -> o.id));
        Fish f = fishList.get(arr[0][0] - 1);
        Shark shark = new Shark(0, 0, f.dir, f.id);
        f.isAlive = false;
        arr[0][0] = -1;

        dfs(arr, shark, fishList);
        System.out.print(max);

        br.close();
    }

    private void dfs(int[][] arr, Shark shark, List<Fish> fishList) {
        max = Math.max(max, shark.eat);

        fishList.forEach(item -> moveFish(item, arr, fishList));

        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.dir] * dist;
            int ny = shark.y + dy[shark.dir] * dist;

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > 0) {
                int[][] arrCp = copyArr(arr);
                List<Fish> fishCp = copyList(fishList);

                arrCp[shark.x][shark.y] = 0;
                Fish f = fishCp.get(arr[nx][ny] - 1);
                Shark nShark = new Shark(f.x, f.y, f.dir, shark.eat + f.id);
                f.isAlive = false;
                arrCp[f.x][f.y] = -1;

                dfs(arrCp, nShark, fishCp);
            }
        }
    }

    private void moveFish(Fish fish, int[][] arr, List<Fish> fishList) {
        if (!fish.isAlive) return;

        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + dx[nextDir];
            int ny = fish.y + dy[nextDir];

            if (0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1) {
                arr[fish.x][fish.y] = 0;

                if (arr[nx][ny] == 0) {
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    Fish tmp = fishList.get(arr[nx][ny] - 1);
                    tmp.x = fish.x;
                    tmp.y = fish.y;
                    arr[fish.x][fish.y] = tmp.id;

                    fish.x = nx;
                    fish.y = ny;
                }

                arr[nx][ny] = fish.id;
                fish.dir = nextDir;
                return;
            }
        }
    }

    private int[][] copyArr(int[][] arr) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(arr[i], 0, tmp[i], 0, 4);
        }
        return tmp;
    }

    private List<Fish> copyList(List<Fish> fishList) {
        List<Fish> tmp = new ArrayList<>();
        fishList.forEach(item -> tmp.add(new Fish(item.x, item.y, item.id, item.dir, item.isAlive)));
        return tmp;
    }

    class Fish {
        int x, y, id, dir;
        boolean isAlive;

        public Fish(int x_, int y_, int id_, int dir_, boolean isAlive_) {
            x = x_;
            y = y_;
            id = id_;
            dir = dir_;
            isAlive = isAlive_;
        }
    }

    class Shark {
        int x, y, dir, eat;

        public Shark(int x_, int y_, int dir_, int eat_) {
            x = x_;
            y = y_;
            dir = dir_;
            eat = eat_;
        }
    }
}
