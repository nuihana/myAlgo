package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16935 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int commandCnt = Integer.parseInt(st.nextToken());

        int[][] set = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                set[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        CustomSet customSet = new CustomSet(set, height, width);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < commandCnt; i++) {
            String command = st.nextToken();
            customSet.change(command);
        }

        customSet.print();

        br.close();
    }

    class CustomSet {
        int[][] value;
        int height;
        int width;

        public CustomSet(int[][] set, int height_, int width_) {
            value = new int[height_][];
            for (int i = 0; i < height_; i++) {
                int[] tmp = set[i];
                value[i] = new int[width_];
                System.arraycopy(tmp, 0, value[i], 0, width_);
            }

            this.height = height_;
            this.width = width_;
        }

        private void verticalReverse() {
            int top = 0;
            int bottom = height - 1;

            while (top < bottom) {
                for (int i = 0; i < width; i++) {
                    int tmp = value[top][i];
                    value[top][i] = value[bottom][i];
                    value[bottom][i] = tmp;
                }
                top++;
                bottom--;
            }
        }
        private void horizontalReverse() {
            int left = 0;
            int right = width - 1;

            while (left < right) {
                for (int i = 0; i < height; i++) {
                    int tmp = value[i][left];
                    value[i][left] = value[i][right];
                    value[i][right] = tmp;
                }
                left++;
                right--;
            }
        }
        private void rotateHalfPieRight() {
            int[][] tmp = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    tmp[i][j] = value[height - 1 - j][i];
                }
            }

            value = tmp;

            int store = width;
            width = height;
            height = store;
        }
        private void rotateHalfPieLeft() {
            int[][] tmp = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    tmp[i][j] = value[j][width - 1 - i];
                }
            }

            value = tmp;

            int store = width;
            width = height;
            height = store;
        }
        private void rotateQuarterRight() {
            int[][] tmp = new int[height][width];

            int half_width = width / 2;
            int half_height = height / 2;

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j][i] = value[j + half_height][i];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j][i + half_width] = value[j][i];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j + half_height][i + half_width] = value[j][i + half_width];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j + half_height][i] = value[j + half_height][i + half_width];
                }
            }

            value = tmp;
        }
        private void rotateQuarterLeft() {
            int[][] tmp = new int[height][width];

            int half_width = width / 2;
            int half_height = height / 2;

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j][i] = value[j][i + half_width];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j][i + half_width] = value[j + half_height][i + half_width];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j + half_height][i + half_width] = value[j + half_height][i];
                }
            }

            for (int i = 0; i < half_width; i++) {
                for (int j = 0; j < half_height; j++) {
                    tmp[j + half_height][i] = value[j][i];
                }
            }

            value = tmp;
        }

        public void print() {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    System.out.print(value[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public void change(String command) {
            if (command.equals("1")) {
                verticalReverse();
            } else if (command.equals("2")) {
                horizontalReverse();
            } else if (command.equals("3")) {
                rotateHalfPieRight();
            } else if (command.equals("4")) {
                rotateHalfPieLeft();
            } else if (command.equals("5")) {
                rotateQuarterRight();
            } else if (command.equals("6")) {
                rotateQuarterLeft();
            }
        }
    }
}
