package BaekJoon.Solve2025.October.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1166 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double s = 0.0, e = Double.MAX_VALUE, res = 0;
        while (s < e) {
            res = (s + e) / 2;
            if ((long) (l / res) * (long) (w / res) * (long) (h / res) < n) {
                if (e == res) break;
                e = res;
            } else {
                if (s == res) break;
                s = res;
            }
        }
        System.out.print(res);

        br.close();
    }
}
