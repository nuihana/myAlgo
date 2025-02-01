package BaekJoon.Solve2025.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem2592 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int fre = -1;
        int freNum = -1;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;

            cntMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if (cntMap.get(num) > fre) {
                fre = cntMap.get(num);
                freNum = num;
            }
        }

        System.out.println(sum / 10);
        System.out.print(freNum);

        br.close();
    }
}
