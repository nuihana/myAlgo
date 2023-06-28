package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2437 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int sum = 1;
        for (int i = 0; i < cnt; i++) {
            if (sum < arr[i]) break;
            sum += arr[i];
        }

        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
