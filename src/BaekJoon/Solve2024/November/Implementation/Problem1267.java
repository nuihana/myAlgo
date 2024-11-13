package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1267 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = 0, m = 0;
        for (int i = 0; i < n; i++) {
            int minute = Integer.parseInt(st.nextToken());

            y += minute / 30 * 10 + 10;
            m += minute / 60 * 15 + 15;
        }

        if (y > m) {
            System.out.print("M ");
            System.out.print(m);
        } else if (y < m) {
            System.out.print("Y ");
            System.out.print(y);
        } else {
            System.out.print("Y M ");
            System.out.print(y);
        }

        br.close();
    }
}
