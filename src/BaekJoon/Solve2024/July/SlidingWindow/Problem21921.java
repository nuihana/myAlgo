package BaekJoon.Solve2024.July.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21921 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tot = Integer.parseInt(st.nextToken());
        int interv = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[tot];
        for (int i = 0; i < tot; i++) arr[i] = Integer.parseInt(st.nextToken());

        long mem = 0;
        long res = 0;
        for (int i = 0; i < interv; i++) mem += arr[i];

        res = mem;
        int cnt = 1;
        for (int i = interv; i < tot; i++) {
            mem -= arr[i - interv];
            mem += arr[i];

            if (mem > res) {
                res = mem;
                cnt = 1;
            } else if (mem == res) {
                cnt++;
            }
        }

        if (res == 0) {
            System.out.print("SAD");
        } else {
            System.out.println(res);
            System.out.print(cnt);
        }

        br.close();
    }
}
