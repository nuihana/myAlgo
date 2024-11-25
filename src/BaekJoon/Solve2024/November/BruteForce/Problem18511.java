package BaekJoon.Solve2024.November.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem18511 {
    int res = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kCnt = Integer.parseInt(st.nextToken());

        int[] kArr = new int[kCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < kCnt; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }

        setRes(n, kArr, 0);
        System.out.print(res);

        br.close();
    }

    private void setRes(int n, int[] arr, int cal) {
        if (cal > n) return;
        res = Math.max(res, cal);

        for (int i = 0; i < arr.length; i++) {
            setRes(n, arr, cal * 10 + arr[i]);
        }
    }
}
