package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem17219 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCnt = Integer.parseInt(st.nextToken());
        int outputCnt = Integer.parseInt(st.nextToken());

        Map<String, String> pwMap = new HashMap<>();
        for (int i = 0; i < inputCnt; i++) {
            st = new StringTokenizer(br.readLine());
            pwMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < outputCnt; i++) {
            bw.write(pwMap.get(br.readLine()));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
