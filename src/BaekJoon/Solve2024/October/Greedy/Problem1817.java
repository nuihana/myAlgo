package BaekJoon.Solve2024.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1817 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bookCnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        if (bookCnt == 0) {
            System.out.print("0");
            return;
        }

        int res = 0;
        int weight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bookCnt; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (weight + now > maxWeight) {
                res++;
                weight = now;
            } else if (weight + now == maxWeight) {
                res++;
                weight = 0;
            } else {
                weight += now;
            }
        }

        while (weight > 0) {
            res++;
            weight -= maxWeight;
        }
        System.out.print(res);

        br.close();
    }
}
