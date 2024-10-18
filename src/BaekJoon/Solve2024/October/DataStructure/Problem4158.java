package BaekJoon.Solve2024.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem4158 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                int cd = Integer.parseInt(br.readLine());
                if (set.contains(cd)) res++;
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
