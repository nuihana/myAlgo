package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30802 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] req = new int[6];
        for (int i = 0; i < 6; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tReq = 0;
        for (int i = 0; i < 6; i++) {
            tReq += req[i] / t + (req[i] % t == 0 ? 0 : 1);
        }
        System.out.println(tReq);
        System.out.print(n / p + " " + n % p);

        br.close();
    }
}
