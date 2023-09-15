package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3108 {
    List<int[]> recList;
    int[] parent;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        recList = new ArrayList<>();
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            recList.add(new int[]{x1, y1, x2, y2});
        }

        recList.add(new int[]{0, 0, 0, 0});

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (overlap(i, j)) {
                    int root_a = find(i);
                    int root_b = find(j);
                    if (root_a > root_b) {
                        int tmp = root_a;
                        root_a = root_b;
                        root_b = tmp;
                    }
                    if (root_a != root_b) parent[root_a] = root_b;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] < 0) res++;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private int find(int idx) {
        if (parent[idx] < 0) return idx;
        return parent[idx] = find(parent[idx]);
    }

    private boolean overlap(int i, int j) {
        int[] reci = recList.get(i);
        int[] recj = recList.get(j);

        if (reci[0] > recj[2] || reci[2] < recj[0]) return false;
        if (reci[1] > recj[3] || reci[3] < recj[1]) return false;
        if (inr(reci[0], reci[2], recj[0], recj[2]) && inr(reci[1], reci[3], recj[1], recj[3])) return false;
        if (inr(recj[0], recj[2], reci[0], reci[2]) && inr(recj[1], recj[3], reci[1], reci[3])) return false;
        return true;
    }
    private boolean inr(int a, int b, int c, int d) {
        return a < c && d < b;
    }
}
