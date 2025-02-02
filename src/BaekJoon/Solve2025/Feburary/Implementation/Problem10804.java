package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10804 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            chgRange(arr, start - 1, end - 1);
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }

        br.close();
    }

    private void chgRange(int[] arr, int start, int end) {
        int[] tmp = new int[20];
        for (int i = 0; i <= end - start; i++) {
            tmp[start + i] = arr[end - i];
        }

        System.arraycopy(tmp, start, arr, start, end - start + 1);
    }
}
