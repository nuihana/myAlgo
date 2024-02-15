package BaekJoon.Solve2024.February.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem3020 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] up = new int[len / 2];
        int[] down = new int[len / 2];
        for (int i = 0; i < len / 2; i++) {
            int d = Integer.parseInt(br.readLine());
            int u = Integer.parseInt(br.readLine());
            down[i] = d;
            up[i] = u;
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int min = len;
        int cnt = 0;
        for (int i = 1; i < height + 1; i++) {
            int conflict = binarySearch(0, len / 2, i, down) + binarySearch(0, len / 2, height - i + 1, up);
            if (min == conflict) {
                cnt++;
                continue;
            }
            if (min > conflict) {
                min = conflict;
                cnt = 1;
            }
        }

        System.out.print(min + " " + cnt);

        br.close();
    }

    private int binarySearch(int l, int r, int h, int[] arr) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return arr.length - r;
    }
}
