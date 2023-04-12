package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem11403 {
    int pointCnt;
    Map<Integer, List<Integer>> pathMap;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        pointCnt = Integer.parseInt(br.readLine());
        pathMap = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < pointCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    if (pathMap.get(i) == null) {
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(j);

                        pathMap.put(i, tmpList);
                    } else {
                        pathMap.get(i).add(j);
                    }
                }
            }
        }

        for (int i = 0; i < pointCnt; i++) {
            bw.write(getLinkedPoint(i));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private String getLinkedPoint(int idx) {
        boolean[] visited = new boolean[pointCnt];
        Queue<Integer> que = new LinkedList<>();
        que.add(idx);

        while(!que.isEmpty()) {
            int tmp = que.poll();

            if (pathMap.get(tmp) != null) {
                for (int p : pathMap.get(tmp)) {
                    if (!visited[p]) {
                        visited[p] = true;
                        que.add(p);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointCnt; i++) {
            if (visited[i]) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        return sb.toString();
    }
}
