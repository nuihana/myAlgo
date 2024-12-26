package BaekJoon.Solve2024.December.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25379 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(Math.min(getMinCnt(arr, 0), getMinCnt(arr, 1)));

        br.close();
    }

    private long getMinCnt(int[] arr, int mod) {
        int l = 0;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == mod) res += i - l++;
        }
        return res;
    }
}
