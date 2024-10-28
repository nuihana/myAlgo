package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Arrays.fill(arr, 100000001);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[idx(arr, val)] = val;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 100000001) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(n);

        br.close();
    }

    private int idx(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= val) return i;
        }
        return arr.length;
    }
}
