package BaekJoon.Solve2023.July.ConvexHull;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3679 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = Integer.parseInt(br.readLine());
        while(caseNum-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            List<int[]> pointList = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pointList.add(new int[]{x, y, 0, 0, i});
            }

            pointList.sort((a1, a2) -> {
                if (a1[1] != a2[1]) return a1[1] - a2[1];
                return a1[0] - a2[0];
            });

            int[] start = pointList.get(0);
            for (int i = 1; i < pointList.size(); i++) {
                int[] now = pointList.get(i);

                now[2] = now[0] - start[0];
                now[3] = now[1] - start[1];
            }

            pointList.sort((a1, a2) -> {
                if (a1[3] * a2[2] != a1[2] * a2[3]) return a1[3] * a2[2] - a1[2] * a2[3];
                if (a1[1] != a2[1]) return a1[1] - a2[1];
                return a1[0] - a2[0];
            });

            int last = pointList.size() - 1;
            for (int i = last; i >= 1; i--) {
                if (ccw(pointList.get(0), pointList.get(last), pointList.get(last - 1)) == 0) last--;
                else break;
            }

            List<int[]> tmpList = new ArrayList<>(pointList.subList(last, pointList.size()));
            Collections.reverse(tmpList);
            if (last < pointList.size() - 1) {
                List<int[]> resList = new ArrayList<>();
                for (int i = 0; i < last; i++) {
                    resList.add(pointList.get(i));
                }

                for (int i = 0; i < tmpList.size(); i++) {
                    resList.add(tmpList.get(i));
                }

                pointList = resList;
            }

            for (int[] p : pointList) {
                bw.write(p[4] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int ccw(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }
}
