package BaekJoon.Solve2023.GraphAndCircuit;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Problem2606 {
    boolean[] visited;
    List<Integer>[] network;
    int value = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int computerCnt = Integer.parseInt(br.readLine());
        int networkCnt = Integer.parseInt(br.readLine());
        int startComputer = 1;

        visited = new boolean[computerCnt + 1];
        network = new ArrayList[computerCnt + 1];

        for (int i = 0; i < networkCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (network[from] == null) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.add(to);

                network[from] = tmpList;
            } else {
                network[from].add(to);
            }

            if (network[to] == null) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.add(from);

                network[to] = tmpList;
            } else {
                network[to].add(from);
            }
        }

        bfs(startComputer);

        bw.write(String.valueOf(value));

        br.close();
        bw.close();
    }

    private void bfs(int start) {
        visited[start] = true;

        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while (!que.isEmpty()) {
            int tmp = que.poll();

            if (network[tmp] == null) {
                continue;
            }

            for (int idx : network[tmp]) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    que.add(idx);
                    value++;
                }
            }
        }
    }
}
