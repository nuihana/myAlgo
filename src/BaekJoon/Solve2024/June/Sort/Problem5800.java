package BaekJoon.Solve2024.June.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem5800 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int classCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= classCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int studentCnt = Integer.parseInt(st.nextToken());
            int[] students = new int[studentCnt];
            for (int j = 0; j < studentCnt; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(students);

            int maxGap = -1;
            for (int j = 1; j < studentCnt; j++) {
                maxGap = Math.max(maxGap, students[j] - students[j - 1]);
            }

            sb.append("Class ").append(i).append("\n");
            sb.append("Max ").append(students[studentCnt - 1]).append(", ");
            sb.append("Min ").append(students[0]).append(", ");
            sb.append("Largest gap ").append(maxGap).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
