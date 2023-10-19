package BaekJoon.Solve2023.October.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem12100 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Board init = new Board(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            init.setting(i, st);
        }

        Queue<Board> que = new LinkedList<>();
        que.offer(init);
        int res = 0;
        while (!que.isEmpty()) {
            Board now = que.poll();
            if (now.turn == 5) {
                res = Math.max(res, now.max());
                continue;
            }

            //상
            que.offer(now.tillUp());
            //하
            que.offer(now.tillDown());
            //좌
            que.offer(now.tillLeft());
            //우
            que.offer(now.tillRight());
        }

        System.out.print(res);

        br.close();
    }

    class Board {
        int[][] field;
        int size;
        int turn;

        public Board(int size) {
            turn = 0;
            this.size = size;
            field = new int[size][size];
        }
        public Board(int turn, int[][] field) {
            this.turn = turn + 1;
            this.size = field.length;
            this.field = field;
        }

        public void setting(int n, StringTokenizer st) {
            for (int i = 0; i < size; i++) {
                field[n][i] = Integer.parseInt(st.nextToken());
            }
        }
        public int max() {
            int res = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    res = Math.max(res, field[i][j]);
                }
            }
            return res;
        }
        public Board tillUp() {
            int[][] tilledFiled = new int[size][size];
            for (int j = 0; j < size; j++) {
                int tick = 0;
                boolean isDoubled = false;
                for (int i = 0; i < size; i++) {
                    if (field[i][j] == 0) continue;
                    if (tick > 0 && tilledFiled[tick - 1][j] == field[i][j] && !isDoubled) {
                        isDoubled = true;
                        tilledFiled[tick - 1][j] *= 2;
                        continue;
                    }
                    tilledFiled[tick][j] = field[i][j];
                    tick++;
                    isDoubled = false;
                }
            }
            return new Board(turn, tilledFiled);
        }
        public Board tillDown() {
            int[][] tilledFiled = new int[size][size];
            for (int j = 0; j < size; j++) {
                int tick = size - 1;
                boolean isDoubled = false;
                for (int i = size - 1; i >= 0; i--) {
                    if (field[i][j] == 0) continue;
                    if (tick < size - 1 && tilledFiled[tick + 1][j] == field[i][j] && !isDoubled) {
                        isDoubled = true;
                        tilledFiled[tick + 1][j] *= 2;
                        continue;
                    }
                    tilledFiled[tick][j] = field[i][j];
                    tick--;
                    isDoubled = false;
                }
            }
            return new Board(turn, tilledFiled);
        }
        public Board tillLeft() {
            int[][] tilledFiled = new int[size][size];
            for (int i = 0; i < size; i++) {
                int tick = 0;
                boolean isDoubled = false;
                for (int j = 0; j < size; j++) {
                    if (field[i][j] == 0) continue;
                    if (tick > 0 && tilledFiled[i][tick - 1] == field[i][j] && !isDoubled) {
                        isDoubled = true;
                        tilledFiled[i][tick - 1] *= 2;
                        continue;
                    }
                    tilledFiled[i][tick] = field[i][j];
                    tick++;
                    isDoubled = false;
                }
            }
            return new Board(turn, tilledFiled);
        }
        public Board tillRight() {
            int[][] tilledFiled = new int[size][size];
            for (int i = 0; i < size; i++) {
                int tick = size - 1;
                boolean isDoubled = false;
                for (int j = size - 1; j >= 0; j--) {
                    if (field[i][j] == 0) continue;
                    if (tick < size - 1 && tilledFiled[i][tick + 1] == field[i][j] && !isDoubled) {
                        isDoubled = true;
                        tilledFiled[i][tick + 1] *= 2;
                        continue;
                    }
                    tilledFiled[i][tick] = field[i][j];
                    tick--;
                    isDoubled = false;
                }
            }
            return new Board(turn, tilledFiled);
        }
    }
}
