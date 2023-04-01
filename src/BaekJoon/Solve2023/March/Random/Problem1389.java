package BaekJoon.Solve2023.March.Random;

import java.io.*;
import java.util.*;

public class Problem1389 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken());
        int relationCnt = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
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

        int[] baconNumArr = new int[peopleCnt];
        int[] eachBaconNum;
        for (int i = 1; i <= peopleCnt; i++) {
            eachBaconNum = new int[peopleCnt + 1];
            Queue<Point> que = new LinkedList<>();
            que.offer(new Point(i, 0));

            while(!que.isEmpty()) {
                Point tmp = que.poll();

                if (relationMap.get(tmp.idx) != null) {
                    for (int n : relationMap.get(tmp.idx)) {
                        if (eachBaconNum[n] == 0) {
                            eachBaconNum[n] = tmp.cost + 1;
                            que.add(new Point(n, tmp.cost + 1));
                        }
                    }
                }
            }
            eachBaconNum[i] = 0;

            int result = 0;
            for (int j = 1; j <= peopleCnt; j++) {
                result += eachBaconNum[j];
            }

            baconNumArr[i - 1] = result;
        }

        int min = Integer.MAX_VALUE;
        int minPerson = 0;
        for (int i = peopleCnt - 1; i >= 0; i--) {
            min = Math.min(min, baconNumArr[i]);
            if (min == baconNumArr[i]) {
                minPerson = i + 1;
            }
        }
        bw.write(String.valueOf(minPerson));

        br.close();
        bw.close();
    }

    class Point {
        int idx;
        int cost;
        public Point(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
