package BaekJoon.Solve2024.September.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem5648 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();
        while (n-- > 0) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            list.add(reverseInt(st.nextToken()));
        }

        list.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (long num : list) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private long reverseInt(String val) {
        StringBuilder sb = new StringBuilder();
        for (int i = val.length() - 1; i >= 0; i--) {
            sb.append(val.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
