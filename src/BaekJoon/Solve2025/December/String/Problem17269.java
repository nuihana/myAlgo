package BaekJoon.Solve2025.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem17269 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int[] scores = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

        List<Integer> list = new ArrayList<>();
        while (n > 0 || m > 0) {
            if (n > 0) list.add(scores[a.charAt(a.length() - n--) - 'A']);
            if (m > 0) list.add(scores[b.charAt(b.length() - m--) - 'A']);
        }

        while (list.size() > 2) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                next.add((list.get(i) + list.get(i + 1)) % 10);
            }

            list = next;
        }

        System.out.print((list.get(0) > 0 ? list.get(0) + "" : "") + list.get(1) + "%");

        br.close();
    }
}
