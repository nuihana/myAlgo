package BaekJoon.Solve2023.August.CP_bitmask;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13460 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        Board init = new Board();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == '#') field[i][j] = 1;
                if (c == 'O') field[i][j] = 2;
                if (c == 'B') init.setBlue(i, j);
                if (c == 'R') init.setRed(i, j);
            }
        }

        Queue<Board> que = new LinkedList<>();
        que.offer(init);
        boolean isEnd = false;
        while (!que.isEmpty()) {
            Board now = que.poll();
            if (now.turn >= 10) continue;

            //좌
            if (now.before != 3) {
                Board left = now.moveLeft(field);
                if (left.canContinue()) {
                    if (left.isEnd()) {
                        isEnd = true;
                        bw.write(String.valueOf(left.turn));
                        break;
                    }

                    que.offer(left);
                }
            }
            //상
            if (now.before != 4) {
                Board up = now.moveUp(field);
                if (up.canContinue()) {
                    if (up.isEnd()) {
                        isEnd = true;
                        bw.write(String.valueOf(up.turn));
                        break;
                    }

                    que.offer(up);
                }
            }
            //우
            if (now.before != 1) {
                Board right = now.moveRight(field);
                if (right.canContinue()) {
                    if (right.isEnd()) {
                        isEnd = true;
                        bw.write(String.valueOf(right.turn));
                        break;
                    }

                    que.offer(right);
                }
            }
            //하
            if (now.before != 2) {
                Board down = now.moveDown(field);
                if (down.canContinue()) {
                    if (down.isEnd()) {
                        isEnd = true;
                        bw.write(String.valueOf(down.turn));
                        break;
                    }

                    que.offer(down);
                }
            }
        }

        if (!isEnd) bw.write("-1");

        br.close();
        bw.close();
    }

    class Board {
        int[] blue;
        int[] red;
        int turn;
        int before; // 1: 좌, 2: 상, 3: 우, 4: 하

        public Board() {
            blue = new int[2];
            red = new int[2];
            turn = 0;
            before = 0;
        }
        public Board(int t, int bf) {
            blue = new int[2];
            red = new int[2];
            turn = t + 1;
            before = bf;
        }

        public void setBlue(int x, int y) {
            blue[0] = x;
            blue[1] = y;
        }
        public void setRed(int x, int y) {
            red[0] = x;
            red[1] = y;
        }

        public boolean canContinue() {
            if (blue[0] == -1 && blue[1] == -1) return false; // 파랑이 빠졌으면 실패
            return true;
        }
        public boolean isEnd() {
            if (canContinue()) { // 파랑이 남아있고
                if (red[0] == -1 && red[1] == -1) return true; // 빨강이 빠졌으면 끝
            }
            return false;
        }

        public Board moveLeft(int[][] field) {
            Board next = new Board(turn, 1);

            if (blue[0] == red[0]) {
                if (blue[1] < red[1]) {
                    int bidx = blue[1];
                    while (field[blue[0]][bidx - 1] == 0) {
                        bidx--;
                    }
                    if (field[blue[0]][bidx - 1] == 2) {
                        bidx--;
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(blue[0], bidx);
                    }

                    int ridx = red[1];
                    while (field[red[0]][ridx - 1] == 0 && ridx - 1 != bidx) {
                        ridx--;
                    }
                    if (field[red[0]][ridx - 1] == 2) {
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(red[0], ridx);
                    }
                } else {
                    int ridx = red[1];
                    while (field[red[0]][ridx - 1] == 0) {
                        ridx--;
                    }
                    if (field[red[0]][ridx - 1] == 2) {
                        ridx--;
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(red[0], ridx);
                    }

                    int bidx = blue[1];
                    while (field[blue[0]][bidx - 1] == 0 && bidx - 1 != ridx) {
                        bidx--;
                    }
                    if (field[blue[0]][bidx - 1] == 2) {
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(blue[0], bidx);
                    }
                }
            } else {
                int idx = blue[1];
                while (field[blue[0]][idx - 1] == 0) {
                    idx--;
                }
                if (field[blue[0]][idx - 1] == 2) {
                    next.setBlue(-1, -1);
                } else {
                    next.setBlue(blue[0], idx);
                }

                idx = red[1];
                while (field[red[0]][idx - 1] == 0) {
                    idx--;
                }
                if (field[red[0]][idx - 1] == 2) {
                    next.setRed(-1, -1);
                } else {
                    next.setRed(red[0], idx);
                }
            }

            return next;
        }
        public Board moveUp(int[][] field) {
            Board next = new Board(turn, 2);
            if (blue[1] == red[1]) {
                if (blue[0] < red[0]) {
                    int bidx = blue[0];
                    while (field[bidx - 1][blue[1]] == 0) {
                        bidx--;
                    }
                    if (field[bidx - 1][blue[1]] == 2) {
                        bidx--;
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(bidx, blue[1]);
                    }

                    int ridx = red[0];
                    while (field[ridx - 1][red[1]] == 0 && ridx - 1 != bidx) {
                        ridx--;
                    }
                    if (field[ridx - 1][red[1]] == 2) {
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(ridx, red[1]);
                    }
                } else {
                    int ridx = red[0];
                    while (field[ridx - 1][red[1]] == 0) {
                        ridx--;
                    }
                    if (field[ridx - 1][red[1]] == 2) {
                        ridx--;
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(ridx, red[1]);
                    }

                    int bidx = blue[0];
                    while (field[bidx - 1][blue[1]] == 0 && bidx - 1 != ridx) {
                        bidx--;
                    }
                    if (field[bidx - 1][blue[1]] == 2) {
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(bidx, blue[1]);
                    }
                }
            } else {
                int idx = blue[0];
                while (field[idx - 1][blue[1]] == 0) {
                    idx--;
                }
                if (field[idx - 1][blue[1]] == 2) {
                    next.setBlue(-1, -1);
                } else {
                    next.setBlue(idx, blue[1]);
                }

                idx = red[0];
                while (field[idx - 1][red[1]] == 0) {
                    idx--;
                }
                if (field[idx - 1][red[1]] == 2) {
                    next.setRed(-1, -1);
                } else {
                    next.setRed(idx, red[1]);
                }
            }

            return next;
        }
        public Board moveRight(int[][] field) {
            Board next = new Board(turn, 3);

            if (blue[0] == red[0]) {
                if (blue[1] < red[1]) {
                    int ridx = red[1];
                    while (field[red[0]][ridx + 1] == 0) {
                        ridx++;
                    }
                    if (field[red[0]][ridx + 1] == 2) {
                        ridx++;
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(red[0], ridx);
                    }

                    int bidx = blue[1];
                    while (field[blue[0]][bidx + 1] == 0 && bidx + 1 != ridx) {
                        bidx++;
                    }
                    if (field[blue[0]][bidx + 1] == 2) {
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(blue[0], bidx);
                    }
                } else {
                    int bidx = blue[1];
                    while (field[blue[0]][bidx + 1] == 0) {
                        bidx++;
                    }
                    if (field[blue[0]][bidx + 1] == 2) {
                        bidx++;
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(blue[0], bidx);
                    }

                    int ridx = red[1];
                    while (field[red[0]][ridx + 1] == 0 && ridx + 1 != bidx) {
                        ridx++;
                    }
                    if (field[red[0]][ridx + 1] == 2) {
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(red[0], ridx);
                    }
                }
            } else {
                int idx = blue[1];
                while (field[blue[0]][idx + 1] == 0) {
                    idx++;
                }
                if (field[blue[0]][idx + 1] == 2) {
                    next.setBlue(-1, -1);
                } else {
                    next.setBlue(blue[0], idx);
                }

                idx = red[1];
                while (field[red[0]][idx + 1] == 0) {
                    idx++;
                }
                if (field[red[0]][idx + 1] == 2) {
                    next.setRed(-1, -1);
                } else {
                    next.setRed(red[0], idx);
                }
            }

            return next;
        }
        public Board moveDown(int[][] field) {
            Board next = new Board(turn, 4);
            if (blue[1] == red[1]) {
                if (blue[0] < red[0]) {
                    int ridx = red[0];
                    while (field[ridx + 1][red[1]] == 0) {
                        ridx++;
                    }
                    if (field[ridx + 1][red[1]] == 2) {
                        ridx++;
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(ridx, red[1]);
                    }

                    int bidx = blue[0];
                    while (field[bidx + 1][blue[1]] == 0 && bidx + 1 != ridx) {
                        bidx++;
                    }
                    if (field[bidx + 1][blue[1]] == 2) {
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(bidx, blue[1]);
                    }
                } else {
                    int bidx = blue[0];
                    while (field[bidx + 1][blue[1]] == 0) {
                        bidx++;
                    }
                    if (field[bidx + 1][blue[1]] == 2) {
                        bidx++;
                        next.setBlue(-1, -1);
                    } else {
                        next.setBlue(bidx, blue[1]);
                    }

                    int ridx = red[0];
                    while (field[ridx + 1][red[1]] == 0 && ridx + 1 != bidx) {
                        ridx++;
                    }
                    if (field[ridx + 1][red[1]] == 2) {
                        next.setRed(-1, -1);
                    } else {
                        next.setRed(ridx, red[1]);
                    }
                }
            } else {
                int idx = blue[0];
                while (field[idx + 1][blue[1]] == 0) {
                    idx++;
                }
                if (field[idx + 1][blue[1]] == 2) {
                    next.setBlue(-1, -1);
                } else {
                    next.setBlue(idx, blue[1]);
                }

                idx = red[0];
                while (field[idx + 1][red[1]] == 0) {
                    idx++;
                }
                if (field[idx + 1][red[1]] == 2) {
                    next.setRed(-1, -1);
                } else {
                    next.setRed(idx, red[1]);
                }
            }

            return next;
        }
    }
}
