package BaekJoon.Solve2023.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21758 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] honeys = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += honeys[i];
        }

        int lToR = 0;
        int temp = sum;
        for (int i = n - 2; i > 0; i--) {
            temp += honeys[i + 1] * 2;
            temp -= honeys[i];
            lToR = Math.max(lToR, temp);
        }

        int rToL = 0;
        temp = sum;
        for (int i = 1; i < n - 1; i++) {
            temp += honeys[i - 1] * 2;
            temp -= honeys[i];
            rToL = Math.max(rToL, temp);
        }

        int middle = 0;
        for (int i = 1; i < n - 1; i++) {
            middle = Math.max(middle, sum + honeys[i]);
        }

        System.out.print(Math.max(middle, Math.max(lToR, rToL)));

        br.close();
    }
}
