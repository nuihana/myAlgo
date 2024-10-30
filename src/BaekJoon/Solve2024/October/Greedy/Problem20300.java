package BaekJoon.Solve2024.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20300 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long res = 0;
        int minus = 0;
        if (n % 2 == 1) {
            res = arr[n - 1];
            minus++;
        }

        for (int i = 0; i < n / 2; i++) {
            res = Math.max(res, arr[i] + arr[n - 1 - minus++]);
        }
        System.out.print(res);

        br.close();
    }
}
