package BaekJoon.Solve2023.TwoDimensionArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10798 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[5][15];

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.substring(j, j+1);
            }
        }

        for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[j][i] != null ? arr[j][i] : "");
            }
        }

        br.close();
    }
}
