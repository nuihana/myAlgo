package BaekJoon.Solve2023.March.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1074 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int maxSize = (int) Math.pow(2, size);
        int[] searchArr = new int[size];
        for (int i = 0, minX = 0, maxX = maxSize, minY = 0, maxY = maxSize; i < size; i++) {
            int tmp = 0;
            if (x >= (maxX + minX) / 2) {
                tmp += 2;
                minX = (maxX + minX) / 2;
            } else {
                maxX = (maxX + minX) / 2;
            }

            if (y >= (maxY + minY) / 2) {
                tmp += 1;
                minY = (maxY + minY) / 2;
            } else {
                maxY = (maxY + minY) / 2;
            }

            searchArr[i] = tmp;
        }

        int maxIdx = (int) Math.pow(maxSize, 2);
        for (int i = 0, min = 0, max = maxIdx; i < size; i++) {
            int area = searchArr[i];
            if (i == size - 1) {
                bw.write(String.valueOf(min + area));
                break;
            }
            int tmp = max - min;
            min = min + tmp / 4 * area;
            max = max - tmp / 4 * (3 - area);
        }

        br.close();
        bw.close();
    }
}
