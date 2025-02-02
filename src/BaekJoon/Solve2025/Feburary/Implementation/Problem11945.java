package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11945 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] res = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                res[i][j] = line[w - j - 1];
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

        br.close();
    }
}
