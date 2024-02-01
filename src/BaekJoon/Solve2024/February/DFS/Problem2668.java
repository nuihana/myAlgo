package BaekJoon.Solve2024.February.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem2668 {
    List<Integer> list;
    boolean[] visited;
    int[] arr;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (int res : list) {
            System.out.println(res);
        }

        br.close();
    }

    private void dfs(int start, int idx) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], idx);
            visited[arr[start]] = false;
        }

        if (arr[start] == idx) list.add(idx);
    }
}
