package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem9372 {
    boolean[] visited;
    Map<Integer, List<Integer>> pathMap;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nationCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());

            pathMap = new HashMap<>();
            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (pathMap.get(from) == null) {
                    List<Integer> tmpList = new ArrayList<>();

                    tmpList.add(to);

                    pathMap.put(from, tmpList);
                } else {
                    pathMap.get(from).add(to);
                }

                if (pathMap.get(to) == null) {
                    List<Integer> tmpList = new ArrayList<>();

                    tmpList.add(from);

                    pathMap.put(to, tmpList);
                } else {
                    pathMap.get(to).add(from);
                }
            }

            visited = new boolean[nationCnt + 1];
            bw.write(String.valueOf(dfs(1, 0)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int dfs(int idx, int cnt) {
        visited[idx] = true;
        if (pathMap.get(idx) != null) {
            for (int to : pathMap.get(idx)) {
                if (!visited[to]) {
                    cnt = dfs(idx, cnt + 1);
                }
            }
        }
        return cnt;
    }
}
