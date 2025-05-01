package BaekJoon.Solve2025.May.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10822 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String[] nums = src.split(",");

        int res = 0;
        for (String num : nums) {
            res += Integer.parseInt(num);
        }

        System.out.print(res);

        br.close();
    }
}
