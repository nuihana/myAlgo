package BaekJoon.Solve2024.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem20115 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] drinks = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(drinks);

        float res = drinks[n - 1];
        float half = 0;
        for (int i = 0; i < n - 1; i++) {
            half += drinks[i];
        }

        res += half / 2;
        System.out.print(res);

        br.close();
    }
}
