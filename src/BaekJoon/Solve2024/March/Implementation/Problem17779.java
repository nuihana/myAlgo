package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem17779 {
    int size, totalCitizen;
    int[][] citizen;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        totalCitizen = 0;
        citizen = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                citizen[i][j] = Integer.parseInt(st.nextToken());
                totalCitizen += citizen[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                for (int d1 = 1; d1 < size; d1++) {
                    for (int d2 = 1; d2 < size; d2++) {
                        if (x + d1 + d2 >= size) continue;
                        if (y - d1 < 0 || y + d2 >= size) continue;

                        min = Math.min(min, solution(x, y, d1, d2));
                    }
                }
            }
        }

        System.out.print(min);

        br.close();
    }

    private int solution(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[size][size];

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        // 1 구역 인구수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                peopleSum[0] += citizen[i][j];
            }
        }

        // 2 구역 인구수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = size - 1; j > y; j--) {
                if (border[i][j]) break;
                peopleSum[1] += citizen[i][j];
            }
        }

        // 3 구역 인구수
        for (int i = x + d1; i < size; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                peopleSum[2] += citizen[i][j];
            }
        }

        // 4 구역 인구수
        for (int i = x + d2 + 1; i < size; i++) {
            for (int j = size - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                peopleSum[3] += citizen[i][j];
            }
        }

        // 5 구역 인구수
        peopleSum[4] = totalCitizen;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 정렬
        Arrays.sort(peopleSum);

        return peopleSum[4] - peopleSum[0];
    }
}
