package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem20125 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        char[][] map = new char[len][len];
        for (int i = 0; i < len; i++) {
            map[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        boolean isDone = false;
        for (int i = 0; i < len && !isDone; i++) {
            for (int j = 0; j < len && !isDone; j++) {
                if (map[i][j] == '*') {
                    sb.append(i + 2).append(" ").append(j + 1).append("\n");

                    int x = i + 1;
                    int y = j;

                    int ty = y;
                    int leftArm = 0;
                    while (--ty >= 0 && map[x][ty] == '*') {
                        leftArm++;
                    }

                    ty = y;
                    int rightArm = 0;
                    while (++ty < len && map[x][ty] == '*') {
                        rightArm++;
                    }

                    int tx = x;
                    ty = y;
                    int body = 0;
                    while (++tx < len && map[tx][ty] == '*') {
                        body++;
                    }

                    x = tx - 1;
                    y = ty - 1;
                    int leftLeg = 0;
                    while (++x < len && map[x][y] == '*') {
                        leftLeg++;
                    }

                    x = tx - 1;
                    y = ty + 1;
                    int rightLeg = 0;
                    while (++x < len && map[x][y] == '*') {
                        rightLeg++;
                    }

                    sb.append(leftArm).append(" ").append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
                    isDone = true;
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}
