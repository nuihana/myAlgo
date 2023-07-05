package BaekJoon.Solve2023.July.Geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem16155 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pointCnt = Integer.parseInt(br.readLine());
        pointCnt++; //시작점 포함

        List<long[]> pointList = new ArrayList<>();
        for (int i = 0; i < pointCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            pointList.add(new long[]{x, y});
        }
        pointList.add(new long[]{99999, 99999});

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int idx = -1;

        long sp;
        long sch;
        while (start >= pointList.get(++idx)[0]);
        idx--;
        sp = pointList.get(idx + 1)[0] - pointList.get(idx)[0];
        sch = (start - pointList.get(idx)[0]) * (pointList.get(idx + 1)[1] - pointList.get(idx)[1]) + pointList.get(idx)[1] * sp;

        idx = -1;
        long ep;
        long ech;
        while (end >= pointList.get(++idx)[0]);
        idx--;
        if (idx == pointCnt - 1) idx--;
        ep = pointList.get(idx + 1)[0] - pointList.get(idx)[0];
        ech = (end - pointList.get(idx)[0]) * (pointList.get(idx + 1)[1] - pointList.get(idx)[1]) + pointList.get(idx)[1] * ep;

        long x = (end - start) * sp * ep;
        long y = Math.abs(sch * ep - ech * sp);

        long gcd = GCD(x, y);
        x /= gcd;
        y /= gcd;
        if (y == 0) bw.write("0");
        else if (x == 1) bw.write(String.valueOf(y));
        else bw.write(y + "/" + x);

        br.close();
        bw.close();
    }

    private long GCD(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b) return GCD(b, a % b);
        else return GCD(a, b % a);
    }
}
