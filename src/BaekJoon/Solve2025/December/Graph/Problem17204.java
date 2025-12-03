package BaekJoon.Solve2025.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem17204 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        boolean possible = true;
        int res = 0, idx = 0;
        while (true) {
            int next = arr[idx];
            res++;

            if (isVisited[next]) {
                possible = false;
                break;
            } else if (next == k) {
                break;
            }

            isVisited[next] = true;
            idx = next;
        }

        if (possible) System.out.print(res);
        else System.out.print(-1);

        br.close();
    }
}
