package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16431 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int jx = Integer.parseInt(st.nextToken());
        int jy = Integer.parseInt(st.nextToken());

        int dDist = Math.abs(jx - dx) + Math.abs(jy - dy);
        int tmpx = Math.abs(jx - bx);
        int tmpy = Math.abs(jy - by);
        int bDist = tmpx + tmpy - Math.min(tmpx, tmpy);

        if (dDist == bDist) {
            System.out.print("tie");
        } else if (dDist > bDist) {
            System.out.print("bessie");
        } else {
            System.out.print("daisy");
        }

        br.close();
    }
}
