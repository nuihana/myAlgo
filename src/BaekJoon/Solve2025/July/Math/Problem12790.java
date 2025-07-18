package BaekJoon.Solve2025.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12790 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 4; i++) {
                arr[i] += Integer.parseInt(st.nextToken());
            }

            if (arr[0] < 1) arr[0] = 1;
            if (arr[1] < 1) arr[1] = 1;
            if (arr[2] < 0) arr[2] = 0;

            sb.append(arr[0] * 1 + arr[1] * 5 + arr[2] * 2 + arr[3] * 2).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
