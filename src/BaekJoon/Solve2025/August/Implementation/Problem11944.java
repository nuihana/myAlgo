package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11944 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String nStr = st.nextToken();
        int n = Integer.parseInt(nStr);
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nStr.length(); j++) {
                if (m == 0) break;
                sb.append(nStr.charAt(j));
                m--;
            }
            if (m == 0) break;
        }
        System.out.print(sb);

        br.close();
    }
}
