package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17388 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int soong = Integer.parseInt(st.nextToken());
        int kor = Integer.parseInt(st.nextToken());
        int han = Integer.parseInt(st.nextToken());

        int min = Math.min(soong, Math.min(kor, han));
        if (soong + kor + han >= 100) {
            System.out.print("OK");
        } else {
            if (min == soong) {
                System.out.print("Soongsil");
            } else if (min == kor) {
                System.out.print("Korea");
            } else if (min == han) {
                System.out.print("Hanyang");
            }
        }

        br.close();
    }
}
