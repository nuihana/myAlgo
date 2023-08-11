package BaekJoon.Solve2023.August.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2864 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        String maxa = a.replaceAll("5", "6");
        String maxb = b.replaceAll("5", "6");

        String mina = a.replaceAll("6", "5");
        String minb = b.replaceAll("6", "5");

        int minres = Integer.parseInt(mina) + Integer.parseInt(minb);
        int maxres = Integer.parseInt(maxa) + Integer.parseInt(maxb);
        bw.write(minres + " " + maxres);

        br.close();
        bw.close();
    }
}
