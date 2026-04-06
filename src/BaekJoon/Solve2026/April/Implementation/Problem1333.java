package BaekJoon.Solve2026.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1333 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int time = 0;
        while (n > 0) {
            time += l;
            n--;

            for (int i = 0; i < 5; i++) {
                if (time % d == 0) {
                    System.out.print(time);
                    return;
                }
                time++;
            }
        }

        while (time % d != 0) time++;
        System.out.print(time);

        br.close();
    }
}
