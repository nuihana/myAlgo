package BaekJoon.Solve2024.December.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15954 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double res = Double.MAX_VALUE;
        double tmp = 0;
        for (int i = k; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                double m = avg(arr, j, i);
                tmp = standardDeviation(arr, m, j, i);
                res = Math.min(res, tmp);
            }
        }

        System.out.println(res);

        br.close();
    }

    private double avg(int[] arr, int start, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += arr[start + i];
        }
        return sum / k;
    }

    private double standardDeviation(int[] arr, double m, int start, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += Math.pow(arr[start + i] - m, 2);
        }
        return Math.sqrt(sum / k);
    }
}
