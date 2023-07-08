package BaekJoon.Solve2023.July.Geometry;

import java.io.*;
import java.util.*;

public class Problem10216 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            int cnt = Integer.parseInt(br.readLine());

            uf = new int[cnt];
            for (int i = 1; i < cnt; i++) {
                uf[i] = i;
            }

            List<Range> rangeList = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                rangeList.add(new Range(x, y, radius));
            }

            for (int i = 0; i < cnt; i++) {
                Range now = rangeList.get(i);
                for (int j = i + 1; j < rangeList.size(); j++) {
                    Range cpr = rangeList.get(j);

                    if (now.isDuplicate(cpr)) {
                        union(i, j);
                    }
                }
            }

            Set<Integer> rootSet = new HashSet<>();
            for (int i = 0; i < cnt; i++) {
                rootSet.add(find(i));
            }

            bw.write(String.valueOf(rootSet.size()));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int find(int n) {
        while(n != uf[n]) {
            n = uf[n];
        }

        return n;
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            uf[root_b] = root_a;
        }
    }

    class Range {
        int x;
        int y;
        int radius;

        public Range(int x_, int y_, int rad_) {
            x = x_;
            y = y_;
            radius = rad_;
        }

        public boolean isDuplicate(Range another) {
            int distancePow = (another.x - x) * (another.x - x) + (another.y - y) * (another.y - y);
            int rangePow = (another.radius + radius) * (another.radius + radius);
            return rangePow >= distancePow;
        }
    }
}
