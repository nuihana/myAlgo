package BaekJoon.Solve2023.June.Greedy;

import java.io.*;

public class Problem12904 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String start = br.readLine();
        String end = br.readLine();
        String res = "0";
        while(!end.equals("") && !end.equals(start)) {
            if (end.charAt(end.length() - 1) == 'A') {
                end = end.substring(0, end.length() - 1);
            } else if (end.charAt(end.length() - 1) == 'B'){
                StringBuilder sb = new StringBuilder(end.substring(0, end.length() - 1));
                sb.reverse();
                end = sb.toString();
            } else {
                break;
            }
        }
        if (end.equals(start)) {
            res = "1";
        }

        bw.write(res);

        br.close();
        bw.close();
    }
}
