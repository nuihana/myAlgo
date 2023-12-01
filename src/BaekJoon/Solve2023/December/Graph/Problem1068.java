package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1068 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> roots = new ArrayList<>();
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) roots.add(i);
            else tree[parent].add(i);
        }

        int cut = Integer.parseInt(br.readLine());
        tree[cut].clear();

        Queue<Integer> que = new LinkedList<>(roots);
        int result = 0;
        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == cut) continue;

            for (int leaf : tree[now]) {
                if (leaf == cut) {
                    if (tree[now].size() == 1) result++;
                    continue;
                }
                que.offer(leaf);
                if (tree[leaf].isEmpty()) result++;
            }
        }

        System.out.print(result);

        br.close();
    }
}
