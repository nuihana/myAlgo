package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2947 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (!isDone(arr)) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;

                    for (int j = 0; j < 5; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isDone(int[] arr) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != i + 1) return false;
        }
        return true;
    }
}
