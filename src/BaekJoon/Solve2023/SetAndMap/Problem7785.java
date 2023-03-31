package BaekJoon.Solve2023.SetAndMap;

import java.io.*;
import java.util.*;

public class Problem7785 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int logCnt = Integer.parseInt(br.readLine());
        Set<String> logSet = new HashSet<>();
        for (int i = 0; i < logCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            String act = st.nextToken();

            if (act.equals("enter")) {
                logSet.add(target);
            } else if (act.equals("leave")) {
                logSet.remove(target);
            }
        }
        List<String> sortedList = new ArrayList<>(logSet);
        sortedList.sort((o1, o2) -> o1.compareTo(o2));

        for (int i = 0; i < sortedList.size(); i++) {
            bw.write(sortedList.get(i));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
