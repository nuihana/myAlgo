package BaekJoon.Solve2025.September.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11663 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dots = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int lIdx = findMin(dots, l);
            int rIdx = findMax(dots, r);
            sb.append(rIdx - lIdx).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int findMin(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    private int findMax(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] > val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
