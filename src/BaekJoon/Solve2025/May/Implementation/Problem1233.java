package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1233 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        int[] sum = new int[s1 + s2 + s3 + 1];
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    sum[i + j + k]++;
                }
            }
        }

        int max = -1;
        int res = -1;
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] > max) {
                max = sum[i];
                res = i;
            }
        }

        System.out.print(res);

        br.close();
    }
}
