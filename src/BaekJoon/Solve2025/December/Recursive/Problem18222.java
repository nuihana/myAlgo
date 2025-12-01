package BaekJoon.Solve2025.December.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem18222 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());
        long[] arr = new long[64];
        arr[0] = 1;
        for (int i = 1; i < 64; i++) {
            arr[i] = arr[i - 1] * 2;
        }
        System.out.print(getNth(arr, k));

        br.close();
    }

    private int getNth(long[] arr, long n) {
        if (n == 1) return 0;
        for (int i = 0; i < 64; i++) {
            if (arr[i] >= n) return 1 - getNth(arr, n - arr[i - 1]);
        }
        return 0;
    }
}
