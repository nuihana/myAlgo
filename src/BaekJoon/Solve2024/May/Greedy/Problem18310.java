package BaekJoon.Solve2024.May.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem18310 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int houseCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] house = new int[houseCnt];
        for (int i = 0; i < houseCnt; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        Arrays.sort(house);
        if (houseCnt % 2 == 0) {
            idx = houseCnt / 2 - 1;
        } else {
            idx = houseCnt / 2;
        }

        System.out.print(house[idx]);

        br.close();
    }
}
