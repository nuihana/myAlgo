package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2605 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> ord = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int jump = Integer.parseInt(st.nextToken());
            ord.add(ord.size() - jump, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ord) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
