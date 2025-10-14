package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem28215 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = Integer.MAX_VALUE;
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                res = Math.min(res, search(n, arr, i, i, i));
            }
        } else if (k == 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    res = Math.min(res, search(n, arr, i, j, j));
                }
            }
        } else if (k == 3) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int l = j + 1; l < n; l++) {
                        res = Math.min(res, search(n, arr, i, j, l));
                    }
                }
            }
        }

        System.out.print(res);

        br.close();
    }

    private int search(int n, int[][] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(arr[i][0] - arr[a][0]) + Math.abs(arr[i][1] - arr[a][1]);
            tmp = Math.min(tmp, Math.abs(arr[i][0] - arr[b][0]) + Math.abs(arr[i][1] - arr[b][1]));
            tmp = Math.min(tmp, Math.abs(arr[i][0] - arr[c][0]) + Math.abs(arr[i][1] - arr[c][1]));

            res = Math.max(res, tmp);
        }
        return res;
    }
}
