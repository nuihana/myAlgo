package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17135 {
    int row, col, range;
    int[] archer = new int[3];
    int[][] map;
    List<int[]> enemy;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        enemy = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) enemy.add(new int[]{ i, j });
            }
        }

        System.out.print(locateArcher(0, 0));

        br.close();
    }

    private int locateArcher(int depth, int idx) {
        if (depth == 3) {
            return runDefence(copy(enemy));
        }

        int result = 0;
        for (int i = idx; i < col; i++) {
            archer[depth] = i;
            result = Math.max(result, locateArcher(depth + 1, i + 1));
        }

        return result;
    }

    private static List<int[]> copy(List<int[]> list) {
        List<int[]> tmp = new ArrayList<>();
        for (int[] item : list) {
            tmp.add(new int[]{ item[0], item[1] });
        }
        return tmp;
    }

    private int runDefence(List<int[]> monsters) {
        int cnt = 0;

        while (true) {
            if (monsters.isEmpty()) break;

            List<int[]> targets = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                Queue<Monster> que = new PriorityQueue<>();

                for (int[] cur : monsters) {
                    int d = Math.abs(cur[0] - row) + Math.abs(cur[1] - archer[i]);
                    if (d <= range) que.offer(new Monster(cur[0], cur[1], d));
                }

                if (!que.isEmpty()) {
                    Monster target = que.poll();
                    boolean flag = false;
                    for (int[] cur : targets) {
                        if (target.x == cur[0] && target.y == cur[1]) flag = true;
                    }
                    if (!flag) {
                        targets.add(new int[]{ target.x, target.y });
                    }
                }
            }

            for (int[] target : targets) {
                for (int j = monsters.size() - 1; j >= 0; j--) {
                    if (target[0] == monsters.get(j)[0] && target[1] == monsters.get(j)[1]) {
                        monsters.remove(j);
                        cnt++;
                        break;
                    }
                }
            }

            for (int j = monsters.size() - 1; j >= 0; j--) {
                monsters.get(j)[0] += 1;
                if (monsters.get(j)[0] == row) monsters.remove(j);
            }
        }

        return cnt;
    }

    class Monster implements Comparable<Monster>{
        int x, y, d;

        public Monster(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }


        @Override
        public int compareTo(Monster o) {
            if (this.d == o.d) {
                return this.y - o.y;
            } else {
                return this.d - o.d;
            }
        }
    }
}
