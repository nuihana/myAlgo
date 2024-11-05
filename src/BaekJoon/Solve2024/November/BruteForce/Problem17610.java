package BaekJoon.Solve2024.November.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem17610 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 1;
        for (int i = 0; i < k; i++) {
            max += arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isPossible = new boolean[max];
        dfs(0, 0, k, isPossible, arr);

        int res = 0;
        for (int i = 1; i < max; i++) if (isPossible[i]) res++;
        System.out.print(max - res - 1);

        br.close();
    }

    private void dfs(int sum, int idx, int max, boolean[] chk, int[] arr) {
        if (idx == max) {
            if (sum > 0) chk[sum] = true;
            return;
        }

        dfs(sum, idx + 1, max, chk, arr);
        dfs(sum + arr[idx], idx + 1, max, chk, arr);
        dfs(sum - arr[idx], idx + 1, max, chk, arr);
    }
}
