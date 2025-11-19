package BaekJoon.Solve2025.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14929 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] partSum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            sum += arr[i];
            partSum[i + 1] = sum;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            int calc = partSum[n] - partSum[i + 1];

            res += now * calc;
        }

        System.out.print(res);

        br.close();
    }
}
