package BaekJoon.Solve2024.August.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1358 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int res = 0;
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (isInSqr(width, height, sx, sy, x, y)) {
                res++;
                continue;
            }

            if (isInCir(height / 2, sx, sy + height / 2, x, y)) {
                res++;
                continue;
            }

            if (isInCir(height / 2, sx + width, sy + height / 2, x, y)) {
                res++;
            }
        }
        System.out.print(res);

        br.close();
    }

    private boolean isInSqr(int w, int h, int sx, int sy, int x, int y) {
        return x >= sx && x <= sx + w && y >= sy && y <= sy + h;
    }

    private boolean isInCir(int r, int cx, int cy, int x, int y) {
        int dx = x - cx;
        int dy = y - cy;
        return r * r - dx * dx - dy * dy >= 0;
    }
}
