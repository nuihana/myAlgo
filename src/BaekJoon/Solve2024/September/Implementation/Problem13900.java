package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13900 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        nums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            long tmp = Integer.parseInt(st.nextToken());
            nums[i] = tmp + nums[i - 1];
            sum += nums[i - 1] * tmp;
        }

        System.out.print(sum);

        br.close();
    }
}
