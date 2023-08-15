package BaekJoon.Solve2023.August.Conte_HI;

import java.io.*;
import java.util.*;

public class Problem28445 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());
        st = new StringTokenizer(br.readLine());
        set.add(st.nextToken());
        set.add(st.nextToken());

        List<String> array = new ArrayList<>(set);
        array.sort((s1, s2) -> s1.compareTo(s2));

        for (String head : array) {
            for (String tail : array) {
                bw.write(head.concat(" ").concat(tail));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
