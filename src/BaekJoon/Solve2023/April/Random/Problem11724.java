package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem11724 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pointCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        for (int i = 0; i < lineCnt; i++) {
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

        int[] pointGroup = new int[pointCnt + 1];
        int group = 1;
        for (int i = 1; i <= pointCnt; i++) {
            if (pointGroup[i] == 0) {
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                pointGroup[i] = group;

                while (!que.isEmpty()) {
                    int tmp = que.poll();

                    if (pathMap.get(tmp) != null) {
                        for (int p : pathMap.get(tmp)) {
                            if (pointGroup[p] == 0) {
                                que.add(p);
                                pointGroup[p] = group;
                            }
                        }
                    }
                }

                group++;
            }
        }

        bw.write(String.valueOf(group - 1));

        br.close();
        bw.close();
    }
}
