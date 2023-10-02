package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem17371 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }

        int ans = 0;
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int[] a = list.get(i);
            double maxDist = 0;
            for (int[] b : list) {
                double dist = Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
                maxDist = Math.max(maxDist, dist);
            }
            if (maxDist < minDist) {
                minDist = maxDist;
                ans = i;
            }
        }

        bw.write(list.get(ans)[0] + " " + list.get(ans)[1]);

        br.close();
        bw.close();
    }
}
