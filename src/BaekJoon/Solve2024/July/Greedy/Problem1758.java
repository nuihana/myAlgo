package BaekJoon.Solve2024.July.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1758 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (i1, i2) -> i2.compareTo(i1));

        long res = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr[i] - i;
            if (tip > 0) res += tip;
        }

        System.out.print(res);

        br.close();
    }
}
