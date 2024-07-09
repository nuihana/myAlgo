package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem5568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] tmp = new int[k];
        boolean[] isUsed = new boolean[n];
        Set<String> set = new HashSet<>();
        dfs(set, isUsed, arr, tmp, 0);

        System.out.print(set.size());

        br.close();
    }

    private void dfs(Set<String> set, boolean[] isUsed, int[] arr, int[] ord, int depth) {
        if (depth == ord.length) {
            set.add(makeStr(arr, ord));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                ord[depth] = i;
                dfs(set, isUsed, arr, ord, depth + 1);
                isUsed[i] = false;
            }
        }
    }

    private String makeStr(int[] arr, int[] ord) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ord.length; i++) {
            sb.append(arr[ord[i]]);
        }

        return sb.toString();
    }
}
