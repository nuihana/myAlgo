package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10093 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long start = Math.min(a, b);
        long end = Math.max(a, b);

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(end - start - 1, 0)).append("\n");
        for (long i = start + 1; i < end; i++) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
