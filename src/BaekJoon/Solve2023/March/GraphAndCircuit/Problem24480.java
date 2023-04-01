package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem24480 {
    int[] visit;
    List<Integer>[] lineArr;
    int ord = 1;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        int[] pointArr = new int[pointCnt + 1];
        for (int i = 1; i < pointCnt; i++) {
            pointArr[i] = i;
        }

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
                lineArr[i].sort(Comparator.reverseOrder());
            }
        }

        visit = new int[pointCnt];
        dfs(startPoint);

        for (int i = 0; i < pointCnt; i++) {
            bw.write(String.valueOf(visit[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void dfs(int start) {
        visit[start - 1] = ord++; //정점 방문 set

        if (lineArr[start] == null) {
            return;
        }

        for (int idx : lineArr[start]) {
            if (visit[idx - 1] == 0) {
                dfs(idx);
            }
        }
    }
}
