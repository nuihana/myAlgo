package BaekJoon.Solve2023.September.ConteKukJung;

import java.io.*;
import java.util.*;

public class Problem29753 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String avgStr = st.nextToken();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < avgStr.length(); i++) {
            char c = avgStr.charAt(i);
            if (c == '.') continue;
            sb.append(c);
        }
        int avg = Integer.parseInt(sb.toString());

        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("A+", 450);
        scoreMap.put("A0", 400);
        scoreMap.put("B+", 350);
        scoreMap.put("B0", 300);
        scoreMap.put("C+", 250);
        scoreMap.put("C0", 200);
        scoreMap.put("D+", 150);
        scoreMap.put("D0", 100);
        scoreMap.put("F", 0);

        int totalClass = 0;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int clas = Integer.parseInt(st.nextToken());
            String score = st.nextToken();

            totalClass += clas;
            sum += clas * scoreMap.get(score);
        }

        int clas = Integer.parseInt(br.readLine());
        totalClass += clas;

        String result = "impossible";
        List<String> scoreList = new ArrayList<>(scoreMap.keySet());
        scoreList.sort(Comparator.naturalOrder());
        for (String score : scoreList) {
            int data = (sum + scoreMap.get(score) * clas) / totalClass;
            if (data <= avg) break;
            result = score;
        }

        bw.write(result);

        br.close();
        bw.close();
    }
}
