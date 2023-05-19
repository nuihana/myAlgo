package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1069 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        double toHomeDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double result = 0;
        if (d > t) { // 점프가 빠른 경우
            int jumpTime = (int) (toHomeDistance / d);
            if (jumpTime == 0) {
                result += Math.min(toHomeDistance, Math.min(t + d - toHomeDistance, 2 * t));
            } else {
                result += Math.min((jumpTime + 1) * t, jumpTime * t + toHomeDistance - jumpTime * d);
            }
        } else {
            result = toHomeDistance;
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
