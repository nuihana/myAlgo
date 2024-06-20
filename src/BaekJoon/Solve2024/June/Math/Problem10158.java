package BaekJoon.Solve2024.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10158 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        int x = startX + time;
        int y = startY + time;

        if (x > width) {
            if (x % width == 0) { // side end
                if ((x / width) % 2 == 0) {
                    x = 0;
                } else {
                    x = width;
                }
            } else {
                if ((x / width) % 2 == 0) {
                    x = x % width;
                } else {
                    x = width - (x % width);
                }
            }
        }

        if (y > height) {
            if (y % height == 0) {
                if ((y / height) % 2 == 0) {
                    y = 0;
                } else {
                    y = height;
                }
            } else {
                if ((y / height) % 2 == 0) {
                    y = y % height;
                } else {
                    y = height - (y % height);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        System.out.print(sb);

        br.close();
    }
}
