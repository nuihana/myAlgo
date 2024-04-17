package BaekJoon.Solve2024.April.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2847 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        int val = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= val) {
                res += arr[i] - (val - 1);
            }

            val = Math.min(val - 1, arr[i]);
        }

        System.out.print(res);

        br.close();
    }
}
