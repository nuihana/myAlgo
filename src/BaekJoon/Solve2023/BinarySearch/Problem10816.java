package BaekJoon.Solve2023.BinarySearch;

import java.io.*;
import java.util.*;

public class Problem10816 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int possession = Integer.parseInt(br.readLine());
        Map<Integer, Integer> possessionMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            int value = Integer.valueOf(st.nextToken());
            if (possessionMap.containsKey(value)) {
                possessionMap.replace(value, possessionMap.get(value) + 1);
            } else {
                possessionMap.put(value, 1);
            }
        }

        int input = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            int value = Integer.valueOf(st.nextToken());
            if (possessionMap.containsKey(value)) {
                bw.write(possessionMap.get(value) + " ");
            } else {
                bw.write("0 ");
            }
        }

        bw.close();
        br.close();
    }
}
