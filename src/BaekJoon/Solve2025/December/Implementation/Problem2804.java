package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2804 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int aIdx = -1, bIdx = -1;
        for (int i = 0; i < a.length(); i++) {
            boolean isDone = false;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    aIdx = i;
                    bIdx = j;
                    isDone = true;
                    break;
                }
            }
            if (isDone) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            if (bIdx == i) {
                sb.append(a);
            } else {
                for (int j = 0; j < a.length(); j++) {
                    if (aIdx == j) sb.append(b.charAt(i));
                    else sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
