package BaekJoon.Solve2023.August.Conte_UtilCup1st;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28453 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            bw.write(grade(arr[i]).concat(" "));
        }

        br.close();
        bw.close();
    }

    private String grade(int level) {
        if (level >= 300) return "1";
        if (level >= 275) return "2";
        if (level >= 250) return "3";
        return "4";
    }
}
