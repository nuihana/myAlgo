package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem24445 {
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
        bfs(startPoint);

        for (int i = 0; i < pointCnt; i++) {
            bw.write(String.valueOf(visit[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void bfs(int start) {
        visit[start - 1] = ord++;

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int tmp = que.poll();

            if (lineArr[tmp] == null) {
                continue;
            }

            for (int idx : lineArr[tmp]) {
                if (visit[idx - 1] == 0) {
                    visit[idx - 1] = ord++;
                    que.add(idx);
                }
            }
        }
    }
}
