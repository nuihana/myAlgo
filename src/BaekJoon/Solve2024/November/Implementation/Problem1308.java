package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1308 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowY = Integer.parseInt(st.nextToken());
        int nowM = Integer.parseInt(st.nextToken());
        int nowD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int desY = Integer.parseInt(st.nextToken());
        int desM = Integer.parseInt(st.nextToken());
        int desD = Integer.parseInt(st.nextToken());

        int[] monthly = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (nowY + 1000 < desY || (nowY + 1000 == desY && nowM < desM) || (nowY + 1000 == desY && nowM == desM && nowD <= desD)) {
            System.out.print("gg");
        } else {
            int dDay = 0;
            for (int y = nowY + 1; y < desY; y++) {
                if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                    dDay += 366;
                } else {
                    dDay += 365;
                }
            }

            if (nowY == desY) {
                if (nowM == desM) {
                    dDay += desD - nowD;
                } else {
                    for (int m = nowM + 1; m < desM; m++) {
                        dDay += monthly[m];
                    }

                    if (((nowY % 4 == 0 && nowY % 100 != 0) || nowY % 400 == 0) && nowM <= 2 && desM >= 3) {
                        dDay += 1;
                    }

                    dDay += monthly[nowM - 1] - nowD;
                    dDay += desD;
                }
            } else {
                for (int m = 0; m < desM - 1; m++) {
                    dDay += monthly[m];
                }

                for (int m = nowM; m < 12; m++) {
                    dDay += monthly[m];
                }

                if (((nowY % 4 == 0 && nowY % 100 != 0) || nowY % 400 == 0) && nowM <= 2) {
                    dDay += 1;
                }
                if (((desY % 4 == 0 && desY % 100 != 0) || desY % 400 == 0) && desM >= 3) {
                    dDay += 1;
                }

                dDay += monthly[nowM - 1] - nowD;
                dDay += desD;
            }

            System.out.print("D-" + dDay);
        }

        br.close();
    }
}
