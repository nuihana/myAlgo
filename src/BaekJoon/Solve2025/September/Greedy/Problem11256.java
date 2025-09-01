package BaekJoon.Solve2025.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11256 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> boxes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                boxes.add(r * c);
            }

            boxes.sort(Collections.reverseOrder());
            int res = 0;
            for (int i = 0; i < boxes.size() - 1; i++) {
                if (j <= 0) break;
                res++;
                j -= boxes.get(i);
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
