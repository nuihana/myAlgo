package BaekJoon.Solve2023.November.Conte_SASA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem30502 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 조건 : p true, m false
        // 최대
        boolean[] posP = new boolean[n + 1];
        Arrays.fill(posP, true);
        boolean[] posM = new boolean[n + 1];
        // 최소
        boolean[] negP = new boolean[n + 1];
        boolean[] negM = new boolean[n + 1];
        Arrays.fill(negM, true);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if (b.equals("P")) {
                if (c == 1) {
                    posP[a] = true;
                    negP[a] = true;
                } else {
                    posP[a] = false;
                    negP[a] = false;
                }
            } else if (b.equals("M")) {
                if (c == 1) {
                    posM[a] = true;
                    negM[a] = true;
                } else {
                    posM[a] = false;
                    negM[a] = false;
                }
            }
        }

        int pos = 0;
        int neg = 0;
        for (int i = 1; i <= n; i++) {
            if (posP[i] && !posM[i]) pos++;
            if (negP[i] && !negM[i]) neg++;
        }

        bw.write(neg + " " + pos);

        bw.close();
        br.close();
    }
}
