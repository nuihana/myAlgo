package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1408 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] now = br.readLine().split(":");
        String[] start = br.readLine().split(":");

        int nowH = Integer.parseInt(now[0]);
        int nowM = Integer.parseInt(now[1]);
        int nowS = Integer.parseInt(now[2]);

        int startH = Integer.parseInt(start[0]);
        int startM = Integer.parseInt(start[1]);
        int startS = Integer.parseInt(start[2]);

        int diffS = 0, diffM = 0, diffH = 0;
        boolean isMinusOne = false;

        if (startS - nowS < 0) {
            diffS = startS - nowS + 60;
            isMinusOne = true;
        } else {
            diffS = startS - nowS;
        }

        if (isMinusOne) {
            if (startM - nowM - 1 < 0) {
                diffM = startM - nowM + 59;
            } else {
                diffM = startM - nowM - 1;
                isMinusOne = false;
            }
        } else {
            if (startM - nowM < 0) {
                diffM = startM - nowM + 60;
                isMinusOne = true;
            } else {
                diffM = startM - nowM;
            }
        }

        if (isMinusOne) {
            if (startH - nowH - 1 < 0) {
                diffH = startH - nowH + 23;
            } else {
                diffH = startH - nowH - 1;
            }
        } else {
            if (startH - nowH < 0) {
                diffH = startH - nowH + 24;
            } else {
                diffH = startH - nowH;
            }
        }

        System.out.print(fillZero(diffH) + ":" + fillZero(diffM) + ":" + fillZero(diffS));

        br.close();
    }

    private String fillZero(int val) {
        if (val >= 10) return String.valueOf(val);
        else return "0" + val;
    }
}
