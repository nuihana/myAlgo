package BaekJoon.Solve2023.September.String;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem11656 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        List<String> tailList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            tailList.add(str.substring(i));
        }

        tailList.sort(Comparator.naturalOrder());
        for (String tmp : tailList) {
            bw.write(tmp);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
