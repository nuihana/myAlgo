package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem1013 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";
        while(t-- > 0) {
            String str = br.readLine();
            bw.write(str.matches(pattern) ? "YES" : "NO");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
