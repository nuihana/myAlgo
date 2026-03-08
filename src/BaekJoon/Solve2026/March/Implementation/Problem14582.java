package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14582 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] geminies = new int[9];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            geminies[i] = Integer.parseInt(st.nextToken());
        }
        int[] startLink = new int[9];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            startLink[i] = Integer.parseInt(st.nextToken());
        }

        int gScore = 0, sScore = 0;
        boolean isReverse = false;
        for (int i = 0; i < 9; i++) {
            gScore += geminies[i];

            if (gScore > sScore) isReverse = true;

            sScore += startLink[i];
        }

        if (isReverse && gScore < sScore) System.out.print("Yes");
        else System.out.print("No");

        br.close();
    }
}
