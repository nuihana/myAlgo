package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1922 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comCnt = Integer.parseInt(br.readLine());
        int lineCnt = Integer.parseInt(br.readLine());
        uf = new int[comCnt + 1];
        for (int i = 1; i <= comCnt; i++) uf[i] = i;

        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < lineCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (from == to) continue;
            lines.add(new int[]{ cost, from, to });
        }

        int include = 0;
        int totalCost = 0;
        lines.sort((a1, a2) -> a1[0] - a2[0]);
        for (int[] line : lines) {
            if (find(line[1]) == find(line[2])) continue;
            totalCost += line[0];
            union(line[1], line[2]);
            include++;
            if (include == comCnt - 1) break;
        }

        System.out.print(totalCost);

        br.close();
    }

    private int find(int idx) {
        if (uf[idx] == idx) return idx;
        return uf[idx] = find(uf[idx]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) uf[root_b] = root_a;
    }
}
