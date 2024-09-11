package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem4307 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mapSize = Integer.parseInt(st.nextToken());
            int antCnt = Integer.parseInt(st.nextToken());

            int min = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < antCnt; i++) {
                int pos = Integer.parseInt(br.readLine());

                int shortP = Math.min(pos, mapSize - pos);
                int longP = Math.max(pos, mapSize - pos);

                min = Math.max(min, shortP);
                max = Math.max(max, longP);
            }

            sb.append(min).append(" ")
                    .append(max).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
