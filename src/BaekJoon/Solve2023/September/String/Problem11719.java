package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem11719 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if (input == null) break;
            bw.write(input);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
