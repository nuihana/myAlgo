package BaekJoon.Solve2024.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1485 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int[][] points = new int[4][2];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            double[] distance = new double[6];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    distance[idx++] = getDistance(points[i], points[j]);
                }
            }

            Arrays.sort(distance);

            if (distance[0] == distance[1]
                && distance[1] == distance[2]
                && distance[2] == distance[3]
                && distance[4] == distance[5]) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private double getDistance(int[] p1, int[] p2) {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}
