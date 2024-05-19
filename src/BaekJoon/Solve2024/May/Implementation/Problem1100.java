package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1100 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i % 2; j < 8; j += 2) {
                if (map[i][j] == 'F') res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
