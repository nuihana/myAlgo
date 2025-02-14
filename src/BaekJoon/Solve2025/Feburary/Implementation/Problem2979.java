package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2979 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] parking = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            for (int j = from; j < to; j++) {
                parking[j]++;
            }
        }

        int res = 0;
        for (int i = 1; i < parking.length; i++) {
            if (parking[i] == 1) {
                res += a;
            } else if (parking[i] == 2) {
                res += b * 2;
            } else if (parking[i] == 3) {
                res += c * 3;
            }
        }

        System.out.print(res);

        br.close();
    }
}
