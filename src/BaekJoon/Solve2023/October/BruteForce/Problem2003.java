package BaekJoon.Solve2023.October.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2003 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int[] arr = new int[numCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        int left = 0;
        int right = 1;
        int sum = arr[0];
        while (right < numCnt) {
            if (sum == destination) {
                res++;
                sum -= arr[left];
                left++;
            } else if (sum < destination) {
                sum += arr[right];
                right++;
            } else if (sum > destination) {
                sum -= arr[left];
                left++;
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
