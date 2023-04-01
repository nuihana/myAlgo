package BaekJoon.Solve2023.March.Recursive;

import java.io.*;

public class Problem4779 {
    StringBuilder sb;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            sb = new StringBuilder();
            recursive(Integer.parseInt(line), 0);
            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void recursive(int num, int depth) {
        if (num < depth) {
            return;
        }

        if (depth == 0) {
            sb.append("-");
        } else {
            String tmp = sb.toString();
            sb.setLength(0);
            sb.append(tmp);
            sb.append(tmp.replaceAll("-", " "));
            sb.append(tmp);
        }

        recursive(num, depth + 1);
    }
}
