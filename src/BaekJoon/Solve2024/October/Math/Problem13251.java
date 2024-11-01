package BaekJoon.Solve2024.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13251 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int total = 0;
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int k = Integer.parseInt(br.readLine());

        double res = 0.0;
        for (int i = 0; i < m; i++) {
            if (arr[i] < k) continue;

            double tmp = 1.0;

            for (int j = 0; j < k; j++) {
                tmp *= (double) (arr[i] - j) / (total - j);
            }

            res += tmp;
        }

        System.out.print(res);

        br.close();
    }
}
