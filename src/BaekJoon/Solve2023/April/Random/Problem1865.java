package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem1865 {
    private final int INF = 25000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());
            int reverseCnt = Integer.parseInt(st.nextToken());

            Map<Integer, List<Line>> lineMap = new HashMap<>();

            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                if (lineMap.get(from) == null) {
                    List<Line> tmpList = new ArrayList<>();

                    tmpList.add(new Line(to, cost));

                    lineMap.put(from, tmpList);
                } else {
                    lineMap.get(from).add(new Line(to, cost));
                }

                if (lineMap.get(to) == null) {
                    List<Line> tmpList = new ArrayList<>();

                    tmpList.add(new Line(from, cost));

                    lineMap.put(to, tmpList);
                } else {
                    lineMap.get(to).add(new Line(from, cost));
                }
            }

            int startIdx = 0;

            for (int j = 0; j < reverseCnt; j++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                startIdx = to;

                if (lineMap.get(from) == null) {
                    List<Line> tmpList = new ArrayList<>();

                    tmpList.add(new Line(to, cost * -1));

                    lineMap.put(from, tmpList);
                } else {
                    lineMap.get(from).add(new Line(to, cost * -1));
                }
            }

            int[] costArr = new int[nodeCnt + 1];
            Arrays.fill(costArr, INF);
            costArr[startIdx] = 0;
            boolean flag = false;

            for (int j = 1; j <= nodeCnt; j++) {
                for (int k = 1; k <= nodeCnt; k++) {
                    if (lineMap.get(k) != null) {
                        for (Line l : lineMap.get(k)) {
                            if (costArr[l.idx] > costArr[k] + l.cost) {
                                if (j == nodeCnt) {
                                    flag = true;
                                }
                                costArr[l.idx] = costArr[k] + l.cost;
                            }
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

    class Line {
        int idx;
        int cost;

        public Line(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
