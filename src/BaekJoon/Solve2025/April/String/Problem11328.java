package BaekJoon.Solve2025.April.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11328 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String src = st.nextToken();
            String cpr = st.nextToken();

            if (isPossible(src, cpr)) {
                sb.append("Possible").append("\n");
            } else {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isPossible(String a, String b) {
        int[] aCnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            aCnt[c - 'a']++;
        }

        int[] bCnt = new int[26];
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            bCnt[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (aCnt[i] != bCnt[i]) return false;
        }
        return true;
    }
}
