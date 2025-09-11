package BaekJoon.Solve2025.September.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15973 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int asx = Integer.parseInt(st.nextToken());
        int asy = Integer.parseInt(st.nextToken());
        int aex = Integer.parseInt(st.nextToken());
        int aey = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bsx = Integer.parseInt(st.nextToken());
        int bsy = Integer.parseInt(st.nextToken());
        int bex = Integer.parseInt(st.nextToken());
        int bey = Integer.parseInt(st.nextToken());

        if (aex < bsx || bex < asx || aey < bsy || bey < asy) {
            System.out.println("NULL");
        } else if ((asx == bex && asy == bey) ||
                    (aex == bsx && asy == bey) ||
                    (asx == bex && aey == bsy) ||
                    (aex == bsx && aey == bsy)) {
            System.out.println("POINT");
        } else if (asx == bex || aex == bsx || asy == bey || aey == bsy) {
            System.out.println("LINE");
        } else {
            System.out.println("FACE");
        }

        br.close();
    }
}
