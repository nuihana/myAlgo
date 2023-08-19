package BaekJoon.Solve2023.August.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem16958 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<int[]> city = new ArrayList<>();
        List<int[]> telCity = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int isTel = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (isTel == 1) {
                city.add(new int[]{isTel, x, y, 0});
                telCity.add(new int[]{x, y});
            } else {
                city.add(new int[]{isTel, x, y, 2001});
            }
        }

        for (int[] now : city) {
            if (now[0] == 1) continue;
            int min = Integer.MAX_VALUE;
            for (int[] tel : telCity) {
                min = Math.min(min, dist(now[1], now[2], tel[0], tel[1]));
            }
            now[3] = min;
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(minDist(city.get(from - 1), city.get(to - 1), t)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private int minDist(int[] from, int[] to, int t) {
        int res = Integer.MAX_VALUE;
        res = Math.min(res, dist(from[1], from[2], to[1], to[2])); // 직접 거리
        res = Math.min(res, from[3] + t + to[3]); // 텔레포트
        return res;
    }
}
