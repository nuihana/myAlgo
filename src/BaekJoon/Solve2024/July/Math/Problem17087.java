package BaekJoon.Solve2024.July.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17087 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - s);
        }

        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res = GCD(res, arr[i]);
        }

        System.out.print(res);

        br.close();
    }

    private int GCD(int a, int b) {
        if (a > b) {
            return a % b == 0 ? b : GCD(b, a % b);
        } else if (a < b) {
            return b % a == 0 ? a : GCD(a, b % a);
        } else {
            return a;
        }
    }
}
