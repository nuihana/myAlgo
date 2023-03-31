package BaekJoon.Solve2023.Advanced_2;

import java.io.*;
import java.util.*;

public class Problem26069 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int actCnt = Integer.parseInt(br.readLine());
        Set<String> dancingSet = new HashSet<>();
        StringTokenizer st;
        dancingSet.add("ChongChong");
        for (int i = 0; i < actCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String bf = st.nextToken();
            String af = st.nextToken();
            if (dancingSet.contains(bf) || dancingSet.contains(af)) {
                dancingSet.add(bf);
                dancingSet.add(af);
            }
        }
        bw.write(String.valueOf(dancingSet.size()));

        br.close();
        bw.close();
    }
}
