package BaekJoon.Solve2023.August.Greedy;

import java.io.*;
import java.util.Arrays;

public class Problem10610 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        char[] arr = input.toCharArray();
        Arrays.sort(arr);

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (arr[0] != '0' || sum % 3 != 0) {
            bw.write("-1");
        } else {
            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }
}
