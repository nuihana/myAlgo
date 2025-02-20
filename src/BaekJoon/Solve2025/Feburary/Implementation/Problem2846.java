package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2846 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int bottom = arr[i];
            while (i + 1 < n && arr[i + 1] > arr[i]) i++;

            res = Math.max(res, arr[i] - bottom);
        }
        System.out.print(res);

        br.close();
    }
}
