package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2491 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 1;
        int bf = arr[0];
        int up = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] >= bf) up++;
            else up = 1;

            bf = arr[i];
            res = Math.max(res, up);
        }

        bf = arr[0];
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] <= bf) down++;
            else down = 1;

            bf = arr[i];
            res = Math.max(res, down);
        }

        System.out.print(res);

        br.close();
    }
}
