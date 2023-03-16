package BaekJoon.Solve2023.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem1260 {
    boolean[] dfsVisited;
    int[] dfsVisit;
    boolean[] bfsVisited;
    int[] bfsVisit;
    List<Integer>[] lineArr;
    int bfsOrd = 1;
    int dfsOrd = 1;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        lineArr = new ArrayList[pointCnt + 1];
        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (lineArr[from] == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(to);

                lineArr[from] = tmp;
            } else {
                lineArr[from].add(to);
            }

            if (lineArr[to] == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(from);

                lineArr[to] = tmp;
            } else {
                lineArr[to].add(from);
            }
        }

        for (int i = 1; i <= pointCnt; i++) {
            if (lineArr[i] != null) {
                lineArr[i].sort(Comparator.naturalOrder());
            }
        }

        bfsVisit = new int[pointCnt];
        bfsVisited = new boolean[pointCnt];
        bfs(startPoint);

        dfsVisit = new int[pointCnt];
        dfsVisited = new boolean[pointCnt];
        dfs(startPoint);

        for (int i = 0; i < pointCnt; i++) {
            if (dfsVisit[i] > 0) {
                bw.write(dfsVisit[i] + " ");
            }
        }
        bw.newLine();
        for (int i = 0; i < pointCnt; i++) {
            if (bfsVisit[i] > 0) {
                bw.write(bfsVisit[i] + " ");
            }
        }

        br.close();
        bw.close();
    }

    private void bfs(int start) {
        bfsVisited[start - 1] = true;
        bfsVisit[bfsOrd++] = start;

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int tmp = que.poll();

            if (lineArr[tmp] == null) {
                continue;
            }

            for (int idx : lineArr[tmp]) {
                if (!bfsVisited[idx - 1]) {
                    bfsVisited[idx - 1] = true;
                    bfsVisit[bfsOrd++] = idx;
                    que.add(idx);
                }
            }
        }
    }

    private void dfs(int start) {
        dfsVisited[start - 1] = true;
        dfsVisit[dfsOrd++] = start;

        if (lineArr[start] == null) {
            return;
        }

        for (int idx : lineArr[start]) {
            if (!dfsVisited[idx - 1]) {
                dfs(idx);
            }
        }
    }
}
