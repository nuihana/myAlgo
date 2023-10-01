package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13164 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            que.offer(arr[i] - arr[i - 1]);
        }

        k--;
        while (k-- > 0) {
            que.poll();
        }

        int res = 0;
        while (!que.isEmpty()) {
            res += que.poll();
        }
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
