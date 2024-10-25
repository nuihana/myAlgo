package BaekJoon.Solve2024.October.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1337 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int min = 5;
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int need = 5;
            for (int j = 0; j < 5; j++) {
                if (isIn(arr, num + j)) need--;
            }
            min = Math.min(min, need);
        }
        System.out.print(min);

        br.close();
    }

    private boolean isIn(int[] arr, int val) {
        for (int n : arr) {
            if (n == val) return true;
        }
        return false;
    }
}
