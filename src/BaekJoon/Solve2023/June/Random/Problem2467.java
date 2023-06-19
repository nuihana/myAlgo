package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2467 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = cnt - 1;
        int minimum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int dif = arr[left] + arr[right];

            if (minimum > Math.abs(dif)) {
                minimum = Math.abs(dif);

                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (dif > 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(result[0] + " " + result[1]);

        br.close();
        bw.close();
    }
}
