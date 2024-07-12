package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1059 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        arr[size + 1] = 1000;
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < n && n < arr[i]) {
                for (int s = arr[i - 1] + 1; s < arr[i]; s++) {
                    for (int e = s + 1; e < arr[i]; e++) {
                        if (isIn(s, e, n)) res++;
                    }
                }
            }
        }

        System.out.print(res);

        br.close();
    }

    private boolean isIn(int s, int e, int n) {
        return s <= n && n <= e;
    }
}
