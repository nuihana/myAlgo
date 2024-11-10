package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15312 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        int[] cnt = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

        int[] arr = new int[a.length() + b.length()];
        for (int i = 0, j = 0; i < a.length(); i++) {
            arr[j++] = cnt[a.charAt(i) - 'A'];
            arr[j++] = cnt[b.charAt(i) - 'A'];
        }

        int size = arr.length;
        while (size > 2) {
            int[] tmp = new int[size-- - 1];

            for (int i = 0; i < size; i++) {
                tmp[i] = (arr[i] + arr[i + 1]) % 10;
            }

            arr = tmp;
        }

        System.out.print(String.valueOf(arr[0]).concat(String.valueOf(arr[1])));

        br.close();
    }
}
