package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15953 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            sb.append(getTotalPrize(first, second)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int getTotalPrize(int first, int second) {
        int res = 0;

        if (first > 0) {
            if (first == 1) {
                res += 5000000;
            } else if (first <= 3) {
                res += 3000000;
            } else if (first <= 6) {
                res += 2000000;
            } else if (first <= 10) {
                res += 500000;
            } else if (first <= 15) {
                res += 300000;
            } else if (first <= 21) {
                res += 100000;
            }
        }

        if (second > 0) {
            if (second == 1) {
                res += 5120000;
            } else if (second <= 3) {
                res += 2560000;
            } else if (second <= 7) {
                res += 1280000;
            } else if (second <= 15) {
                res += 640000;
            } else if (second <= 31) {
                res += 320000;
            }
        }

        return res;
    }
}
