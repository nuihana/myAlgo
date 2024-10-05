package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10824 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        a = a.concat(st.nextToken());
        String b = st.nextToken();
        b = b.concat(st.nextToken());

        System.out.print(Long.parseLong(a) + Long.parseLong(b));

        br.close();
    }
}
