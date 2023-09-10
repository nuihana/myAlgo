package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem10953 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            String[] arr = input.split(",");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            bw.write(String.valueOf(a + b));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
