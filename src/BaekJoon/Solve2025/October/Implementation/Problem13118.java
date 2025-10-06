package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13118 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cr = Integer.parseInt(st.nextToken());

        if (cx == x1) {
            System.out.print(1);
        } else if (cx == x2) {
            System.out.print(2);
        } else if (cx == x3) {
            System.out.print(3);
        } else if (cx == x4) {
            System.out.print(4);
        } else {
            System.out.print(0);
        }

        br.close();
    }
}
