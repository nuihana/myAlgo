package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2863 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lt = Integer.parseInt(st.nextToken());
        int rt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int lb = Integer.parseInt(st.nextToken());
        int rb = Integer.parseInt(st.nextToken());

        int res = 0;
        double value = (double) lt / lb + (double) rt / rb;

        double tmp = (double) lb / rb + (double) lt / rt;
        if (value < tmp) {
            res = 1;
            value = tmp;
        }

        tmp = (double) rb / rt + (double) lb / lt;
        if (value < tmp) {
            res = 2;
            value = tmp;
        }

        tmp = (double) rt / lt + (double) rb / lb;
        if (value < tmp) {
            res = 3;
        }
        System.out.print(res);

        br.close();
    }
}
