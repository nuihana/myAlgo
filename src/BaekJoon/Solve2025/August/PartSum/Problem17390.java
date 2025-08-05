package BaekJoon.Solve2025.August.PartSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem17390 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int qCnt = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] partSum = new int[len + 1];
        partSum[1] = arr[0];
        for (int i = 2; i <= len; i++) {
            partSum[i] = partSum[i - 1] + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (qCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(partSum[r] - partSum[l - 1]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
