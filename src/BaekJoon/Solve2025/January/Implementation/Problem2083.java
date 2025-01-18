package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2083 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (name.equals("#")) break;
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            sb.append(name).append(" ");
            if (age > 17 || weight >= 80) {
                sb.append("Senior");
            } else {
                sb.append("Junior");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
