package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2840 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] wheel = new int[n];
        Arrays.fill(wheel, -1);
        int now = 0;
        boolean isPossible = true;
        while(k-- > 0 && isPossible) {
            st = new StringTokenizer(br.readLine());

            int turn = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            now = (now + turn) % n;
            if (wheel[now] == -1) {
                wheel[now] = c - 'A';
            } else {
                if (wheel[now] != (c - 'A')) {
                    isPossible = false;
                }
            }
        }

        boolean[] isUnique = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (wheel[i] != -1) {
                if (isUnique[wheel[i]]) {
                    isPossible = false;
                }

                isUnique[wheel[i]] = true;
            }
        }

        if (isPossible) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int idx = now - i >= 0 ? (now - i) % n : (now - i + n) % n;
                if (wheel[idx] != -1) {
                    sb.append((char) (wheel[idx] + 'A'));
                } else {
                    sb.append("?");
                }
            }
            System.out.print(sb);
        } else {
            System.out.print("!");
        }

        br.close();
    }
}
