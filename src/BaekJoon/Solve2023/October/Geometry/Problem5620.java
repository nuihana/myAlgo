package BaekJoon.Solve2023.October.Geometry;

import java.io.*;
import java.util.*;

public class Problem5620 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> pList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            pList.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }
        pList.sort((a1, a2) -> a1[0] - a2[0]); // x좌표 오름차순

        TreeSet<int[]> set = new TreeSet<>((a1, a2) -> (a1[1] == a2[1]) ? a1[0] - a2[0] : a1[1] - a2[1]);
        set.add(pList.get(0));
        set.add(pList.get(1));

        int res = lenPow(pList.get(0), pList.get(1));
        int start = 0;

        for (int i = 2; i < n; i++) {
            int[] now = pList.get(i);

            while (start < i) {
                int[] p = pList.get(start);
                int xDif = now[0] - p[0];

                if (xDif * xDif > res) {
                    set.remove(p);
                    start++;
                } else {
                    break;
                }
            }

            int d = (int) Math.sqrt(res) + 1;

            int[] from = { -100000, now[1] - d };
            int[] to = { 100000, now[1] + d };

            for (int[] p : set.subSet(from, to)) {
                res = Math.min(res, lenPow(now, p));
            }

            set.add(now);
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private int lenPow(int[] a, int[] b) {
        return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
    }
}
