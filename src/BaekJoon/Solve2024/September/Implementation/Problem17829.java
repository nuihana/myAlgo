package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem17829 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(getPooling(arr, size));

        br.close();
    }

    private int getPooling(int[][] arr, int size) {
        if (size == 1) return arr[0][0];

        int[][] tmp = new int[size / 2][size / 2];
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                tmp[i][j] = getSecondMin(arr[i * 2][j * 2], arr[i * 2][j * 2 + 1], arr[i * 2 + 1][j * 2], arr[i * 2 + 1][j * 2 + 1]);
            }
        }

        return getPooling(tmp, size / 2);
    }

    private int getSecondMin(int a, int b, int c, int d) {
        int[] arr = new int[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;

        Arrays.sort(arr);
        return arr[2];
    }
}
