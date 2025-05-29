package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14659 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int h = arr[i];
            int tmp = 0;
            while (i + 1 < n && arr[i + 1] < h) {
                tmp++;
                i++;
            }

            res = Math.max(res, tmp);
        }

        System.out.print(res);

        br.close();
    }
}
