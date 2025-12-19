package BaekJoon.Solve2025.December.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem16208 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int len = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            len += arr[i];
        }

        long res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            len -= arr[i];
            res += len * arr[i];
        }
        System.out.print(res);

        br.close();
    }
}
