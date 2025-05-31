package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1592 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int rec = 0;
        int res = 0;
        int[] arr = new int[n];
        while (true) {
            if (arr[rec] % 2 == 1) {
                rec = (rec + l) % n;
            } else {
                rec = (rec - l + n) % n;
            }

            arr[rec]++;
            if (arr[rec] == m) break;
            res++;
        }

        System.out.print(res);

        br.close();
    }
}
