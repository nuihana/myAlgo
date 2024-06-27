package BaekJoon.Solve2024.June.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9934 {
    int idx = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int[] tree = new int[(1 << k) - 1];
        int[] arr = new int[(1 << k) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(k, 0, 0, tree, arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0, idx = 0; i < k; i++) {
            for (int j = 0; j < (1 << i); j++) {
                sb.append(tree[idx++]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private void dfs(int level, int depth, int tIdx, int[] tree, int[] val) {
        if (level == depth) {
            return;
        }

        dfs(level, depth + 1, (tIdx + 1) * 2 - 1, tree, val);
        tree[tIdx] = val[idx++];
        dfs(level, depth + 1, (tIdx + 1) * 2, tree, val);
    }
}
