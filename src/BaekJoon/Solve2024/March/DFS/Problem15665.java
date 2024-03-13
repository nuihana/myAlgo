package BaekJoon.Solve2024.March.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15665 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        List<Integer> numList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!numList.contains(num)) numList.add(num);
        }

        numList.sort(Comparator.naturalOrder());
        int[] res = new int[len];
        StringBuilder sb = new StringBuilder();
        dfs(sb, numList, 0, res);
        System.out.print(sb);

        br.close();
    }

    private void dfs(StringBuilder sb, List<Integer> list, int idx, int[] res) {
        if (idx == res.length) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            res[idx] = list.get(i);
            dfs(sb, list, idx + 1, res);
        }
    }
}
