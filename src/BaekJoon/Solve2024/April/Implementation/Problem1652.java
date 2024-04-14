package BaekJoon.Solve2024.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1652 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        char[][] room = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < size; i++) {
            int n = 0;
            for (int j = 0; j < size; j++) {
                if (room[i][j] == 'X') {
                    if (n >= 2) {
                        horizontal++;
                    }

                    n = 0;
                } else {
                    n++;
                }
            }

            if (n >= 2) horizontal++;
        }

        for (int i = 0; i < size; i++) {
            int n = 0;
            for (int j = 0; j < size; j++) {
                if (room[j][i] == 'X') {
                    if (n >= 2) {
                        vertical++;
                    }

                    n = 0;
                } else {
                    n++;
                }
            }

            if (n >= 2) vertical++;
        }

        System.out.print(horizontal + " " + vertical);

        br.close();
    }
}
