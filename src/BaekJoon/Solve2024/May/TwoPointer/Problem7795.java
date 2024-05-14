package BaekJoon.Solve2024.May.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7795 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int caseCnt = Integer.parseInt(br.readLine());
        while (caseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lCnt = Integer.parseInt(st.nextToken());
            int rCnt = Integer.parseInt(st.nextToken());

            int[] left = new int[lCnt];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lCnt; i++) {
                left[i] = Integer.parseInt(st.nextToken());
            }

            int[] right = new int[rCnt];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < rCnt; i++) {
                right[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(left);
            Arrays.sort(right);

            long res = 0;
            int l = 0;
            int r = 0;

            while (l < lCnt) {
                while (r < rCnt && left[l] > right[r]) r++;

                res += r;
                l++;
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
