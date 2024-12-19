package BaekJoon.Solve2024.December.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12847 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] reward = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            reward[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = m;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += reward[i];
        }

        long res = sum;
        while (r < n){
            sum -= reward[l++];
            sum += reward[r++];
            res = Math.max(res, sum);
        }

        System.out.print(res);

        br.close();
    }
}
