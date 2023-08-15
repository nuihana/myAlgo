package BaekJoon.Solve2023.August.Conte_HI;

import java.io.*;
import java.util.*;

public class Problem28446 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("1")) {
                String idx = st.nextToken();
                int weight = Integer.parseInt(st.nextToken());
                map.put(weight, idx);
            } else if (command.equals("2")) {
                int req = Integer.parseInt(st.nextToken());
                bw.write(map.get(req));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
