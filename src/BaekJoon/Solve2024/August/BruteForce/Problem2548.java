package BaekJoon.Solve2024.August.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2548 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.print(getRepresentNum(arr));

        br.close();
    }

    private int getRepresentNum(int[] arr) {
        int mid = arr.length / 2;

        int res = arr[mid];
        int sum = getDistSum(arr, mid);
        if (arr.length > 1 && sum >= getDistSum(arr, mid - 1)) {
            res = arr[mid - 1];
            sum = getDistSum(arr, mid - 1);
        }
        if (arr.length > 2 && sum > getDistSum(arr, mid + 1)) {
            res = arr[mid + 1];
        }
        return res;
    }

    private int getDistSum(int[] arr, int idx) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == idx) continue;
            res += Math.abs(arr[i] - arr[idx]);
        }
        return res;
    }
}
