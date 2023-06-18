package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.*;

public class Problem28235 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().trim();

        if (str.equals("SONGDO")) {
            bw.write("HIGHSCHOOL");
        } else if (str.equals("CODE")) {
            bw.write("MASTER");
        } else if (str.equals("2023")) {
            bw.write("0611");
        } else if (str.equals("ALGORITHM")) {
            bw.write("CONTEST");
        }

        br.close();
        bw.close();
    }
}
