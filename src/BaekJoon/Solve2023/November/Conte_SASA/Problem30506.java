package BaekJoon.Solve2023.November.Conte_SASA;

import java.io.*;
import java.util.Arrays;

public class Problem30506 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int size = 100;
        int[] res = new int[size];
        Arrays.fill(res, 2);
        int first = -1;
        int idx = 0;
        while (true) {
            int ans = Integer.parseInt(br.readLine());

            if (first >= 0) {
                if (ans == first) {
                    res[idx - 1] = 0;
                } else if (ans > first) {
                    res[idx - 1] = 5;
                }

                if (idx == size) break;
            }

            if (first < 0) first = ans;

            if (ans == size) break;
            StringBuilder sb = new StringBuilder();
            sb.append("? ");
            //질의
            for (int i = 0; i < size; i++) {
                if (i == idx) sb.append("5");
                else sb.append("2");
            }
            System.out.println(sb);
            System.out.flush();

            idx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("! ");
        for (int i = 0; i < size; i++) {
            if (res[i] == 0) sb.append("2");
            else if (res[i] == 2) sb.append("5");
            else sb.append("0");
        }
        System.out.print(sb);
        System.out.flush();

        br.close();
        System.exit(0);
    }
}
