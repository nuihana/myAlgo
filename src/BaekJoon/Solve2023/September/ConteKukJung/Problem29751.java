package BaekJoon.Solve2023.September.ConteKukJung;

import java.io.*;
import java.util.StringTokenizer;

public class Problem29751 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        double res = (double) width * height / 2;
        bw.write(String.format(".1f", res));

        br.close();
        bw.close();
    }
}
