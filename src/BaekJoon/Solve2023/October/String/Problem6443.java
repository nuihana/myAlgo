package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.*;

public class Problem6443 {
    int[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String src = br.readLine();
            visited = new int[26];
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                visited[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            backTracking(src.length(), 0, new char[src.length()], sb);
            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void backTracking(int len, int idx, char[] ans, StringBuilder sb) {
        if (len == idx) {
            sb.append(ans);
            sb.append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                ans[idx] = (char) ('a' + i);
                backTracking(len, idx + 1, ans, sb);
                visited[i]++;
            }
        }
    }
}
