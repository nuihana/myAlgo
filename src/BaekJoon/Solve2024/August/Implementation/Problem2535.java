package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2535 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            students.add(new int[]{ nation, id, score });
        }

        students.sort((a1, a2) -> a2[2] - a1[2]);
        int[] nations = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0, idx = 0; i < 3; i++) {
            while (!isPossible(nations, students.get(idx))) {
                idx++;
            }

            nations[students.get(idx)[0]]++;
            sb.append(students.get(idx)[0]).append(" ").append(students.get(idx)[1]).append("\n");
            idx++;
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isPossible(int[] nations, int[] student) {
        return nations[student[0]] < 2;
    }
}
