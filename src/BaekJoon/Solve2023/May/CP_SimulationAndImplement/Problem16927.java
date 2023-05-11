package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16927 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        int[][] origin = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        RotateSet set = new RotateSet(origin, height, width);
        set.rotate(turn);
        set.print();

        br.close();
    }

    class RotateSet {
        int height;
        int width;
        int[][] value; //원본
        int[][] calcArr;

        public RotateSet(int[][] set, int height_, int width_) {
            this.value = new int[height_][];
            for (int i = 0; i < height_; i++) {
                int[] tmp = set[i];
                value[i] = new int[width_];
                System.arraycopy(tmp, 0, value[i], 0, width_);
            }

            this.height = height_;
            this.width = width_;

            int minSize = Math.min(height, width);
            int arrCnt = minSize / 2;

            this.calcArr = new int[arrCnt][];

            for (int i = 0; i < arrCnt; i++) {
                int tmpWidth = width - i * 2;
                int tmpHeight = height - i * 2;
                int arrLen = tmpHeight * 2 + tmpWidth * 2 - 4;
                calcArr[i] = new int[arrLen];

                int x_root = i;
                int y_root = i;
                int idx = 0;
                while (y_root < i + tmpWidth) {
                    calcArr[i][idx] = value[x_root][y_root];
                    idx++;
                    y_root++;
                }
                idx--;
                y_root--;

                while (x_root < i + tmpHeight) {
                    calcArr[i][idx] = value[x_root][y_root];
                    idx++;
                    x_root++;
                }
                idx--;
                x_root--;

                while (y_root >= i) {
                    calcArr[i][idx] = value[x_root][y_root];
                    idx++;
                    y_root--;
                }
                idx--;
                y_root++;

                while (x_root > i) {
                    calcArr[i][idx] = value[x_root][y_root];
                    idx++;
                    x_root--;
                }
            }
        }

        public void print() {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(value[i][j] + " ");
                }
                System.out.println();
            }
        }
        public void rotate(int cnt) {
            for (int i = 0; i < calcArr.length; i++) {
                int thisLen = calcArr[i].length;
                int tmpCnt = cnt % thisLen;

                int[] tmpArr = new int[thisLen];
                for (int j = 0; j < thisLen; j++) {
                    tmpArr[j] = calcArr[i][(j + tmpCnt) % thisLen];
                }

                calcArr[i] = tmpArr;
            }

            for (int i = 0; i < calcArr.length; i++) {
                int tmpWidth = width - i * 2;
                int tmpHeight = height - i * 2;

                int x_root = i;
                int y_root = i;
                int idx = 0;
                while (y_root < i + tmpWidth) {
                    value[x_root][y_root] = calcArr[i][idx];
                    idx++;
                    y_root++;
                }
                idx--;
                y_root--;

                while (x_root < i + tmpHeight) {
                    value[x_root][y_root] = calcArr[i][idx];
                    idx++;
                    x_root++;
                }
                idx--;
                x_root--;

                while (y_root >= i) {
                    value[x_root][y_root] = calcArr[i][idx];
                    idx++;
                    y_root--;
                }
                idx--;
                y_root++;

                while (x_root > i) {
                    value[x_root][y_root] = calcArr[i][idx];
                    idx++;
                    x_root--;
                }
            }
        }
    }
}
