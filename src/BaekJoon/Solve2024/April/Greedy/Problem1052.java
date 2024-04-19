package BaekJoon.Solve2024.April.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1052 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bottleCnt = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int res = 0;
        while (true) {
            int min = getMinBottle(bottleCnt + res);
            if (min > capacity) res++;
            else break;
        }

        System.out.print(res);

        br.close();
    }

    private int getMinBottle(int n) {
        int res = 1;

        while (n > 1) {
            res += n % 2;
            n /= 2;
        }

        return res;
    }
}
