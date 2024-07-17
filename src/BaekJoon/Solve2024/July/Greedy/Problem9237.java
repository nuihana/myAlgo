package BaekJoon.Solve2024.July.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem9237 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1);

        int res = 0, day = 1;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(res, arr[i] + day);
            day++;
        }

        System.out.print(res + 1);

        br.close();
    }

    private void quickSort(int[] arr, int s, int e) {
        int pivot = arr[s];
        int ns = s, ne = e;
        while (s < e) {
            while (arr[pivot] <= arr[e] && s < e) e--;
            if (s > e) break;
            while (arr[pivot] >= arr[s] && s < e) s++;
            if (s > e) break;

            int tmp = arr[e];
            arr[e] = arr[s];
            arr[s] = tmp;
        }

        int tmp = arr[ns];
        arr[ns] = arr[s];
        arr[s] = tmp;

        if (ns < s) quickSort(arr, ns, s - 1);
        if (ne > e) quickSort(arr, s + 1, ne);
    }
}
