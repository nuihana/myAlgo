package BaekJoon.Solve2023.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem16234 {
    int[][] nations;
    int[] unionFind;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        nations = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int turn = 0;
        while (hasOpen(n, l, r)) {
            turn++;
            merge(n);
        }

        System.out.print(turn);

        br.close();
    }

    private int find(int idx) {
        if (unionFind[idx] == idx) return idx;
        return unionFind[idx] = find(unionFind[idx]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            unionFind[root_b] = root_a;
        }
    }

    private int idx(int i, int j, int n) {
        return n * i + j;
    }

    private int[] idx(int num, int n) {
        return new int[]{ num / n, num % n };
    }

    private boolean hasOpen(int n, int l, int r) {
        boolean res = false;

        unionFind =  new int[n * n];
        for (int i = 1; i < unionFind.length; i++) unionFind[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //오른쪽
                if (j < n - 1) {
                    int dif = Math.abs(nations[i][j + 1] - nations[i][j]);
                    if (l <= dif && dif <= r) {
                        res = true;
                        union(idx(i, j, n), idx(i, j + 1, n));
                    }
                }
                //아래
                if (i < n - 1) {
                    int dif = Math.abs(nations[i + 1][j] - nations[i][j]);
                    if (l <= dif && dif <= r) {
                        res = true;
                        union(idx(i, j, n), idx(i + 1, j, n));
                    }
                }
            }
        }

        return res;
    }

    private void merge(int n) {
        List<Integer>[] group = new ArrayList[n * n];
        int[] sum = new int[n * n];
        for (int i = 0; i < n * n; i++) group[i] = new ArrayList<>();

        for (int i = 0; i < unionFind.length; i++) {
            int root = find(i);
            int[] id = idx(i, n);
            group[root].add(i);
            sum[root] += nations[id[0]][id[1]];
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 0) continue;

            for (int num : group[i]) {
                int[] id = idx(num, n);
                nations[id[0]][id[1]] = sum[i] / group[i].size();
            }
        }
    }
}
