package BaekJoon.Solve2026.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2991 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            int time = Integer.parseInt(st.nextToken());
            int dog1 = time % (a + b);
            int dog2 = time % (c + d);

            if (dog1 <= a && dog1 != 0) cnt++;
            if (dog2 <= c && dog2 != 0) cnt++;
            System.out.println(cnt);
        }

        br.close();
    }
}
