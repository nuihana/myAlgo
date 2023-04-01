package BaekJoon.Solve2023.March.Advanced_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25206 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int entireCapa = 0;
        Float entireScore = 0F;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            st.nextToken();
            int capa = Integer.parseInt(st.nextToken().split("[.]")[0]);
            String score = st.nextToken();

            if (score.equals("A+")) {
                entireScore += 4.5F * capa;
            } else if (score.equals("A0")) {
                entireScore += 4.0F * capa;
            } else if (score.equals("B+")) {
                entireScore += 3.5F * capa;
            } else if (score.equals("B0")) {
                entireScore += 3.0F * capa;
            } else if (score.equals("C+")) {
                entireScore += 2.5F * capa;
            } else if (score.equals("C0")) {
                entireScore += 2.0F * capa;
            } else if (score.equals("D+")) {
                entireScore += 1.5F * capa;
            } else if (score.equals("D0")) {
                entireScore += 1.0F * capa;
            } else if (score.equals("F")) {
                entireScore += 0F;
            }

            if (!score.equals("P")) {
                entireCapa += capa;
            }
        }

        System.out.print(entireScore / entireCapa);

        br.close();
    }
}
