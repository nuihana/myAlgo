package BaekJoon.Solve2025.June.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6996 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int[] aCnt = new int[26];
            int[] bCnt = new int[26];

            for (int i = 0; i < a.length(); i++) {
                aCnt[a.charAt(i) - 'a']++;
            }

            for (int i = 0; i < b.length(); i++) {
                bCnt[b.charAt(i) - 'a']++;
            }

            if (isAngr(aCnt, bCnt)) {
                sb.append(a).append(" & ").append(b).append(" are anagrams.").append("\n");
            } else {
                sb.append(a).append(" & ").append(b).append(" are NOT anagrams.").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isAngr(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
