package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.*;

public class Problem4803 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());

            if (nodeCnt == 0 && edgeCnt == 0) {
                break;
            }

            int[] nodeArr = new int[nodeCnt + 1];
            Map<Integer, List<Integer>> edgeMap = new HashMap<>();

            for (int i = 0; i < edgeCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if (edgeMap.get(from) == null) {
                    List<Integer> tmpList = new ArrayList<>();

                    tmpList.add(to);

                    edgeMap.put(from, tmpList);
                } else {
                    edgeMap.get(from).add(to);
                }

                if (edgeMap.get(to) == null) {
                    List<Integer> tmpList = new ArrayList<>();

                    tmpList.add(from);

                    edgeMap.put(to, tmpList);
                } else {
                    edgeMap.get(to).add(from);
                }
            }

            int treeNum = 1;
            Set<Integer> cycleGraphSet = new HashSet<>();
            for (int i = 1; i <= nodeCnt; i++) {
                if (nodeArr[i] == 0) {
                    Queue<Integer> que = new LinkedList<>();
                    nodeArr[i] = treeNum;
                    que.offer(i);

                    while(!que.isEmpty()) {
                        int tmp = que.poll();

                        if (edgeMap.get(tmp) != null) {
                            for (int p : edgeMap.get(tmp)) {
                                if (nodeArr[p] == 0) {
                                    que.offer(p);
                                    nodeArr[p] = treeNum;
                                } else {
                                    cycleGraphSet.add(treeNum);
                                }

                                edgeMap.get(p).remove(new Integer(tmp));
                            }
                        }
                    }

                    treeNum++;
                }
            }

            treeNum -= (cycleGraphSet.size() + 1);

            if (treeNum == 0) {
                bw.write("Case " + caseNum + ": No trees.");
            } else if (treeNum == 1) {
                bw.write("Case " + caseNum + ": There is one tree.");
            } else {
                bw.write("Case " + caseNum + ": A forest of " + treeNum + " trees.");
            }
            bw.newLine();
            caseNum++;
        }

        br.close();
        bw.close();
    }
}
