package BaekJoon.Solve2024.March.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2230 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int minDiff = Integer.parseInt(st.nextToken());

        int[] arr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int l = 0, r = 0, min = Integer.MAX_VALUE;
        while (l <= r && r < numCnt) {
            int diff = arr[r] - arr[l];
            if (minDiff == diff) {
                min = minDiff;
                break;
            } else if (minDiff > diff) {
                r++;
            } else {
                l++;
                min = Math.min(min, diff);
            }
        }

        System.out.print(min);

        br.close();
    }
}
