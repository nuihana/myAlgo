package BaekJoon.Solve2025.August.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1326 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[from] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int now = arr[cur];
            int term = nums[cur];

            int nth = 1;
            while (true) {
                int r = cur + term * nth;
                int l = cur - term * nth;

                if (r > n && l < 1 ) break;
                if (r <= n && arr[r] == -1) {
                    arr[r] = now + 1;
                    q.offer(r);
                }
                if (l >= 1 && arr[l] == -1) {
                    arr[l] = now + 1;
                    q.offer(l);
                }
                nth++;
            }
        }

        System.out.print(arr[to]);

        br.close();
    }
}
