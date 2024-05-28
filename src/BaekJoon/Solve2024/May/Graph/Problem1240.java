package BaekJoon.Solve2024.May.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1240 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());
        final int INF = 10000000;

        int[][] tree = new int[nodeCnt + 1][nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            Arrays.fill(tree[i], INF);
        }

        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            tree[a][b] = dist;
            tree[b][a] = dist;
        }

        floydWarshall(tree, nodeCnt);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(tree[a][b]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private void floydWarshall(int[][] tree, int size) {
        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                for (int j = 0; j <= size; j++) {
                    if (tree[i][k] + tree[k][j] < tree[i][j]) {
                        tree[i][j] = tree[i][k] + tree[k][j];
                    }
                }
            }
        }
    }
}
