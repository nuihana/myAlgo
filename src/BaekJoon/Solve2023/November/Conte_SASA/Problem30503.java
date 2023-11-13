package BaekJoon.Solve2023.November.Conte_SASA;

import java.io.*;
import java.util.StringTokenizer;

public class Problem30503 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] field = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int ord = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (ord == 1) {
                int species = Integer.parseInt(st.nextToken());
                int res = 0;
                for (int j = from; j <= to; j++) {
                    if (field[j] == species) res++;
                }
                bw.write(String.valueOf(res));
                bw.newLine();
            } else {
                for (int j = from; j <= to; j++) {
                    field[j] = 0;
                }
            }
        }

        bw.close();
        br.close();
    }
}
