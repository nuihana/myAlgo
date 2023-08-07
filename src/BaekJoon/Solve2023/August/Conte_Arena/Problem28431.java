package BaekJoon.Solve2023.August.Conte_Arena;

import java.io.*;

public class Problem28431 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n]++;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] % 2 == 1) {
                bw.write(String.valueOf(i + 1));
                break;
            }
        }

        br.close();
        bw.close();
    }
}
