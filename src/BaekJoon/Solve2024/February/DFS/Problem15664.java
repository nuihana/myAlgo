package BaekJoon.Solve2024.February.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem15664 {
    int[] arr;
    Set<Integer> set = new HashSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        arr = new int[numCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        dfs(new int[len], 0, 0, len, sb);
        System.out.print(sb);

        br.close();
    }

    private void dfs(int[] ans, int start, int idx, int len, StringBuilder sb) {
        if (idx == len) {
            int val = 0;
            StringBuilder isb = new StringBuilder();
            for (int i = 0; i < ans.length; i++) {
                val += ans[i] * (int) Math.pow(10, i);
                isb.append(ans[i]).append(" ");
            }

            if (!set.contains(val)) {
                set.add(val);
                sb.append(isb).append("\n");
            }

            return;
        }

        for (int i = start; i < arr.length; i++) {
            ans[idx] = arr[i];
            dfs(ans, i + 1, idx + 1, len, sb);
        }
    }
}
