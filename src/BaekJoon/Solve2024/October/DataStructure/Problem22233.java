package BaekJoon.Solve2024.October.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem22233 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> memo = new HashSet<>();
        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String keyword = br.readLine();
            String[] split = keyword.split(",");

            for (String word : split) {
                memo.remove(word);
            }
            sb.append(memo.size()).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
