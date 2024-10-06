package BaekJoon.Solve2024.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30804 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                max = Math.max(max, getMaxSeq(arr, i, j));
            }
        }
        System.out.print(max);

        br.close();
    }

    private int getMaxSeq(int[] arr, int a, int b) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a || arr[i] == b) {
                int tmp = 1;
                while (++i < arr.length && (arr[i] == a || arr[i] == b)) {
                    tmp++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}
