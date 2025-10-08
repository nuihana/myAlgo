package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3029 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String now = br.readLine();
        String bomb = br.readLine();

        String[] nowS = now.split(":");
        String[] bombS = bomb.split(":");
        int[] diff = new int[3];
        for (int i = 0; i < 3; i++) {
            diff[i] = Integer.parseInt(bombS[i]) - Integer.parseInt(nowS[i]);
        }

        if (now.equals(bomb)) {
            System.out.print("24:00:00");
        } else {
            if (diff[2] < 0) {
                diff[2] += 60;
                diff[1]--;
            }
            if (diff[1] < 0) {
                diff[1] += 60;
                diff[0]--;
            }
            if (diff[0] < 0) diff[0] += 24;
            System.out.print(String.format("%02d:%02d:%02d", diff[0], diff[1], diff[2]));
        }

        br.close();
    }
}
