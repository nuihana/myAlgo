package BaekJoon.Solve2025.April.Implementation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem9076 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Comparator.naturalOrder());

            int max = -1;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 1; i < 4; i++) {
                max = Math.max(arr.get(i), max);
                min = Math.min(arr.get(i), min);
                sum += arr.get(i);
            }

            if (max - min >= 4) {
                sb.append("KIN").append("\n");
            } else {
                sb.append(sum).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
