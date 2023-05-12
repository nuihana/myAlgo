package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14499 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            int command = Integer.parseInt(st.nextToken());

            if (command == 1 && y < width - 1) {
                y++;
            } else if (command == 2 && y > 0) {
                y--;
            } else if (command == 3 && x > 0) {
                x--;
            } else if (command == 4 && x < height - 1){
                x++;
            } else {
                continue;
            }

            dice.command(command);

            if (field[x][y] == 0) {
                field[x][y] = dice.getBottom();
            } else {
                dice.setBottom(field[x][y]);
                field[x][y] = 0;
            }

            bw.write(dice.getTop());
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Dice {
        int[] vertical; // 0: 아래, 1: 남, 2: 위, 3: 북
        int[] horizontal; // 0: 서, 1: 동

        public Dice() {
            vertical = new int[4];
            horizontal = new int[2];
        }

        private void moveEast() {
            int west = horizontal[0];
            int east = horizontal[1];

            horizontal[0] = vertical[0];
            horizontal[1] = vertical[2];
            vertical[0] = east;
            vertical[2] = west;
        }
        private void moveWest() {
            int west = horizontal[0];
            int east = horizontal[1];

            horizontal[0] = vertical[2];
            horizontal[1] = vertical[0];
            vertical[0] = west;
            vertical[2] = east;
        }
        private void moveNorth() {
            int top = vertical[2];
            int bottom = vertical[0];

            vertical[0] = vertical[3];
            vertical[2] = vertical[1];
            vertical[1] = bottom;
            vertical[3] = top;
        }
        private void moveSouth() {
            int top = vertical[2];
            int bottom = vertical[0];

            vertical[0] = vertical[1];
            vertical[2] = vertical[3];
            vertical[1] = top;
            vertical[3] = bottom;
        }

        public void command(int val) {
            if (val == 1) {
                moveEast();
            } else if (val == 2) {
                moveWest();
            } else if (val == 3) {
                moveNorth();
            } else {
                moveSouth();
            }
        }
        public int getBottom() {
            return vertical[0];
        }
        public void setBottom(int value) {
            vertical[0] = value;
        }
        public String getTop() {
            return String.valueOf(vertical[2]);
        }
    }
}
