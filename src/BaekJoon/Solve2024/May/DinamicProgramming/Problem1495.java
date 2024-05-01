package BaekJoon.Solve2024.May.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1495 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int songCnt = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int maximum = Integer.parseInt(st.nextToken());

        int res = -1;

        int[] volume = new int[maximum + 1];
        int[] change = new int[songCnt + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < songCnt; i++) change[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(volume, -1);
        volume[start] = 0;

        for (int i = 1; i <= songCnt; i++) {
            List<Integer> changer = new ArrayList<>();

            for (int j = 0; j <= maximum; j++) {
                if (volume[j] == i - 1) {
                    int minus = j - change[i - 1];
                    int plus = j + change[i - 1];

                    if (minus >= 0) changer.add(minus);
                    if (plus <= maximum) changer.add(plus);
                }
            }

            for (int next : changer) volume[next] = i;
        }

        for (int i = 0; i <= maximum; i++) {
            if (volume[i] == songCnt) res = Math.max(res, i);
        }

        System.out.print(res);

        br.close();
    }
}
