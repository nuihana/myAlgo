package BaekJoon.Solve2023.July.Random;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2473 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] res = new int[3];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < cnt; i++) {
            int left = 0;
            int right = cnt - 1;
            long now = arr[i];
            while (left < right) {
                if (i == left || i == right) {
                    if (now + arr[left] + arr[right] > 0) right--;
                    else left++;
                    continue;
                }

                if (Math.abs(min) > Math.abs(now + arr[left] + arr[right])) {
                    min = now + arr[left] + arr[right];
                    res[0] = arr[left];
                    res[1] = arr[i];
                    res[2] = arr[right];
                }

                if (now + arr[left] + arr[right] > 0) right--;
                else left++;
            }
        }

        Arrays.sort(res);
        bw.write(res[0] + " " + res[1] + " " + res[2]);

        br.close();
        bw.close();
    }
}
