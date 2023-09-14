package BaekJoon.Solve2023.September.Greedy;

import java.io.*;

public class Problem10775 {
    int[] gates;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        gates = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            gates[i] = i;
        }

        int res = 0;
        while (p-- > 0) {
            int gi = Integer.parseInt(br.readLine());

            int root = find(gi);
            if (root == 0) break;

            res++;
            union(root - 1, root);
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private int find(int idx) {
        if (idx == gates[idx]) return idx;
        return gates[idx] = find(gates[idx]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            gates[root_b] = root_a;
        }
    }
}
