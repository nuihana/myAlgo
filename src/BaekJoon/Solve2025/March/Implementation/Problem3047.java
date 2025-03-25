package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3047 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> abc = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            abc.add(Integer.parseInt(st.nextToken()));
        }

        abc.sort(Integer::compareTo);

        String ord = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char c = ord.charAt(i);
            if (c == 'A') {
                sb.append(abc.get(0)).append(" ");
            } else if (c == 'B') {
                sb.append(abc.get(1)).append(" ");
            } else if (c == 'C') {
                sb.append(abc.get(2)).append(" ");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
