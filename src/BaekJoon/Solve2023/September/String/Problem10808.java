package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem10808 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] res = new int[26];
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < res.length; i++) {
            bw.write(res[i] + " ");
        }

        br.close();
        bw.close();
    }
}
