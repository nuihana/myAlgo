package BaekJoon.Solve2025.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7510 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            sb.append("Scenario #").append(i + 1).append(":\n");
            if (Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
