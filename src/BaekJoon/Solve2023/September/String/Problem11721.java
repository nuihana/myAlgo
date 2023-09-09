package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem11721 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && i % 10 == 0) bw.newLine();
            char c = str.charAt(i);
            bw.write(c);
        }

        br.close();
        bw.close();
    }
}
