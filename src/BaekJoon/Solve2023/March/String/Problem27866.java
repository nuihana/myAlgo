package BaekJoon.Solve2023.March.String;

import java.io.*;

public class Problem27866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int idx = Integer.parseInt(br.readLine());

        bw.write(str.substring(idx - 1, idx));

        br.close();
        bw.close();
    }
}
