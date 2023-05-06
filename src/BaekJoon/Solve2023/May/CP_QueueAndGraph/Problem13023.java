package BaekJoon.Solve2023.May.CP_QueueAndGraph;

import java.io.*;
import java.util.*;

public class Problem13023 {
    Map<Integer, List<Integer>> relationMap;
    Queue<Integer> que;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken());
        int relationCnt = Integer.parseInt(st.nextToken());

        relationMap = new HashMap<>();
        for (int i = 0; i < relationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (relationMap.get(a) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(b);

                relationMap.put(a, tmpList);
            } else {
                relationMap.get(a).add(b);
            }

            if (relationMap.get(b) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(a);

                relationMap.put(b, tmpList);
            } else {
                relationMap.get(b).add(a);
            }
        }

        boolean flag = false;
        for (int i = 0; i < peopleCnt; i++) {
            que = new LinkedList<>();
            que.offer(i);
            if (dfs(i) > 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        br.close();
        bw.close();
    }

    private int dfs(int idx) {
        if (que.size() == 5) {
            return 1;
        }

        int doneCase = 0;
        if (relationMap.get(idx) != null) {
            for (int to : relationMap.get(idx)) {
                if (!que.contains(to)) {
                    que.offer(to);
                    doneCase += dfs(to);
                    que.remove(to);
                }
            }
        }
        return doneCase;
    }
}
