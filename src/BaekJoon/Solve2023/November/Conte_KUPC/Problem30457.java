package BaekJoon.Solve2023.November.Conte_KUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem30457 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        boolean[] isIn = new boolean[n];
        int max = arr[n - 1];
        isIn[n - 1] = true;
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (!isIn[i] && max > arr[i]) {
                max = arr[i];
                res++;
                isIn[i] = true;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (!isIn[i]) {
                max = arr[i];
                isIn[i] = true;
                res++;
                break;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (!isIn[i] && max > arr[i]) {
                max = arr[i];
                res++;
                isIn[i] = true;
            }
        }
        System.out.print(res);

        br.close();
    }
}
