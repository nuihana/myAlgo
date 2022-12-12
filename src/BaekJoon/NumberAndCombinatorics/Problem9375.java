package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.*;

public class Problem9375 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCnt; i++) {
            int dressCnt = Integer.parseInt(br.readLine());

            Map<String, Integer> dressRooom = new HashMap<>();
            for (int j = 0; j < dressCnt; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                String type = st.nextToken();

                if (dressRooom.get(type) != null) {
                    dressRooom.put(type, dressRooom.get(type).intValue() + 1);
                } else {
                    dressRooom.put(type, 1);
                }
            }

            int result = 1;

            for (int value : dressRooom.values()) {
                result *= (value + 1);
            }

            result -= 1;

            bw.write(result + "\n");
        }

        bw.close();
        br.close();
    }
}
