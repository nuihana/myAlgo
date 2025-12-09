package BaekJoon.Solve2025.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16439 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] prefer = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                prefer[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(maxPrefer(prefer, new int[3], 0));

        br.close();
    }

    private int maxPrefer(int[][] prefer, int[] arr, int depth) {
        if (depth == 3) {
            return getPrefer(prefer, arr);
        }

        int res = -1;
        for (int i = 0; i < prefer[0].length; i++) {
            arr[depth] = i;
            res = Math.max(res, maxPrefer(prefer, arr, depth + 1));
        }

        return res;
    }

    private int getPrefer(int[][] prefer, int[] arr) {
        int sum = 0;
        for (int i = 0; i < prefer.length; i++) {
            int max = -1;
            for (int j = 0; j < arr.length; j++) {
                max = Math.max(max, prefer[i][arr[j]]);
            }
            sum += max;
        }
        return sum;
    }
}
