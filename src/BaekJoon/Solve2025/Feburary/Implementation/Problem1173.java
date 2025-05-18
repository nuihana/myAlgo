package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1173 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int purpose = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int spend = 0;
        int now = min;
        int work = 0;
        if (now + up > max) {
            System.out.print(-1);
            return;
        }

        while (purpose != work) {
            if (now + up > max) {
                if (now - down < min) {
                    now = min;
                } else {
                    now -= down;
                }
            } else {
                now += up;
                work++;
            }

            spend++;
        }

        System.out.print(spend);

        br.close();
    }
}
