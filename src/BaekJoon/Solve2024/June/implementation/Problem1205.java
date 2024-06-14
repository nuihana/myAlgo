package BaekJoon.Solve2024.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem1205 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        Integer[] scores = new Integer[numCnt];
        if (numCnt > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numCnt; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, Collections.reverseOrder());
        }

        if (numCnt == limit && score <= scores[numCnt - 1]) {
            System.out.print(-1);
        } else {
            int res = 1;
            for (int i = 0; i < numCnt; i++) {
                if (score < scores[i]) res++;
                else break;
            }
            System.out.print(res);
        }

        br.close();
    }
}
