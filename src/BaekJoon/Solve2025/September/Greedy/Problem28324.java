package BaekJoon.Solve2025.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem28324 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        int now = 0;
        for (int i = n - 1; i >= 0; i--) {
            now = Math.min(now + 1, arr[i]);
            res += now;
        }
        System.out.print(res);

        br.close();
    }
}
