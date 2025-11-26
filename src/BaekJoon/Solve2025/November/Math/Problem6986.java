package BaekJoon.Solve2025.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem6986 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);
        double cutAvg = 0, adjAvg = 0;
        for (int i = k; i < n - k; i++) {
            cutAvg += arr[i];
        }
        adjAvg = cutAvg;
        adjAvg += arr[k] * k;
        adjAvg += arr[n - k - 1] * k;
        adjAvg = adjAvg / n;
        cutAvg = cutAvg / (n - 2 * k);

        System.out.println(String.format("%.2f", cutAvg));
        System.out.print(String.format("%.2f", adjAvg));

        br.close();
    }
}
