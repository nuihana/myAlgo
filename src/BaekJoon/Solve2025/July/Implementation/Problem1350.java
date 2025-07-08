package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1350 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] files = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
        int size = Integer.parseInt(br.readLine());

        long res = 0;
        for (int i = 0; i < n; i++) {
            int need = 0;

            need += files[i] / size;
            if (files[i] % size != 0) need++;

            res += size * need;
        }

        System.out.print(res);

        br.close();
    }
}
