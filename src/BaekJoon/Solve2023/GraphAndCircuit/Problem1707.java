package BaekJoon.Solve2023.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem1707 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int i = 0; i < testCaseCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int pointCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());
            int[] pointArr = new int[pointCnt + 1];

            Map<Integer, List<Integer>> lineMap = new HashMap<>();
            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int path1 = Integer.parseInt(st.nextToken());
                int path2 = Integer.parseInt(st.nextToken());

                if (lineMap.get(path1) == null) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(path2);

                    lineMap.put(path1, tmpList);
                } else {
                    lineMap.get(path1).add(path2);
                }

                if (lineMap.get(path2) == null) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(path1);

                    lineMap.put(path2, tmpList);
                } else {
                    lineMap.get(path2).add(path1);
                }
            }

            Queue<Integer> que = new LinkedList<>();
            for (int j = 1; j <= pointCnt; j++) {
                if (lineMap.get(j) == null) {
                    continue;
                }

                pointArr[j] = 1;
                for (int idx : lineMap.get(j)) {
                    pointArr[idx] = 2;
                    que.add(idx);
                }
                break;
            }

            boolean flag = true;
            while(!que.isEmpty()) {
                int tmp = que.poll();
                List<Integer> pathList = lineMap.get(tmp);
                int val = pointArr[tmp] == 1 ? 2 : 1;

                for (int idx : pathList) {
                    if (pointArr[idx] == 0) {
                        pointArr[idx] = val;
                        que.add(idx);
                    } else {
                        if (pointArr[idx] != val) {
                            flag = false;
                            que.clear();
                            break;
                        }
                    }
                }

                if (flag && que.isEmpty()) {
                    for (int j = 1; j <= pointCnt; j++) {
                        if (pointArr[j] == 0 && lineMap.get(j) != null) {
                            que.add(j);
                            break;
                        }
                    }
                }
            }

            if (flag) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
