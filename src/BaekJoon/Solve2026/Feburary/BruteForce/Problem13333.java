package BaekJoon.Solve2026.Feburary.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem13333 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = -1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i && i <= n - j && n - i <= j + 1) res = i;
            }
        }
        System.out.print(res);

        br.close();
    }
}
