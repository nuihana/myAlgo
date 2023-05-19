package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16931 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        Paper paper = new Paper(height, width);
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                paper.setCubeByIdx(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        bw.write(paper.getOuterArea());

        br.close();
        bw.close();
    }

    class Paper {
        int[][] cubeArr;

        public Paper(int height_, int width_) {
            cubeArr = new int[height_][width_];
        }

        private int getXPerspectiveArea() {
            int result = 0;

            for (int i = 0; i < cubeArr.length; i++) {
                for (int j = 0, prev = 0; j < cubeArr[i].length; j++) {
                    if (cubeArr[i][j] > prev) {
                        result += cubeArr[i][j] - prev;
                    }
                    prev = cubeArr[i][j];
                }
            }

            return result;
        }
        private int getYPerspectiveArea() {
            int result = 0;

            for (int i = 0; i < cubeArr[0].length; i++) {
                for (int j = 0, prev = 0; j < cubeArr.length; j++) {
                    if (cubeArr[j][i] > prev) {
                        result += cubeArr[j][i] - prev;
                    }
                    prev = cubeArr[j][i];
                }
            }

            return result;
        }
        private int getZPerspectiveArea() {
            int result = 0;

            for (int i = 0; i < cubeArr.length; i++) {
                for (int j = 0; j < cubeArr[i].length; j++) {
                    if (cubeArr[i][j] > 0) {
                        result++;
                    }
                }
            }

            return result;
        }

        public void setCubeByIdx(int x, int y, int value) {
            cubeArr[x][y] = value;
        }
        public String getOuterArea() {
            int result = 0;

            result += getXPerspectiveArea() * 2;
            result += getYPerspectiveArea() * 2;
            result += getZPerspectiveArea() * 2;

            return String.valueOf(result);
        }
    }
}
