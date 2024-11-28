package BaekJoon.Solve2024.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1500 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int tmp = n / cnt;
        int[] arr = new int[cnt];
        Arrays.fill(arr, tmp);
        int sum = tmp * cnt;
        for (int i = 0; i < cnt; i++) {
            if (sum == n) break;
            sum++;
            arr[i]++;
        }

        long res = arr[0];
        for (int i = 1; i < cnt; i++) {
            res *= arr[i];
        }

        System.out.print(res);

        br.close();
    }
}
