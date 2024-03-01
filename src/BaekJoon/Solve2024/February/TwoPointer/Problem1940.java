package BaekJoon.Solve2024.February.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1940 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int need = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long res = 0;
        int l = 0, r = cnt - 1;
        Arrays.sort(arr);
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == need) {
                res++;
                l++;
            } else if (sum < need) {
                l++;
            } else {
                r--;
            }
        }

        System.out.print(res);

        br.close();
    }
}
