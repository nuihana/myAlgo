package BaekJoon.Solve2023.Advanced_2;

import java.io.*;
import java.util.*;

public class Problem25192 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int chatCnt = Integer.parseInt(br.readLine());
        int result = 0;
        Set<String> imoSet = new HashSet<>();
        for (int i = 0; i < chatCnt; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                result += imoSet.size();
                imoSet.clear();
            } else {
                imoSet.add(chat);
            }
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
