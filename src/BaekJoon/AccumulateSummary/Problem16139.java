package BaekJoon.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16139 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int inputCnt = Integer.parseInt(br.readLine());

        int[][] acSum = new int[26][str.length()];

        for (int i = 0; i < str.length(); i++) {
            acSum[str.charAt(i) - 97][i] += 1;

            if (i != 0) {
                for (int j = 0; j < 26; j++) {
                    acSum[j][i] += acSum[j][i - 1];
                }
            }
        }

        for (int i = 0; i < inputCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char target = st.nextToken().charAt(0);

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (from > 0) {
                bw.write(acSum[target - 97][to] - acSum[target - 97][from - 1] + "\n");
            } else {
                bw.write(acSum[target - 97][to] + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
