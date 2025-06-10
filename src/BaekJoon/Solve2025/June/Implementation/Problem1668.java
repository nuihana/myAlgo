package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1668 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 0;
        int h = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > h) {
                left++;
                h = arr[i];
            }
        }

        int right = 0;
        h = -1;
        for (int i = 0; i < n; i++) {
            if (arr[n - 1 - i] > h) {
                right++;
                h = arr[n - 1 - i];
            }
        }

        System.out.println(left);
        System.out.print(right);

        br.close();
    }
}
