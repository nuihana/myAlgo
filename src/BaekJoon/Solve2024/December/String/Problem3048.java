package BaekJoon.Solve2024.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem3048 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        List<Ant> list = new ArrayList<Ant>();
        char[] ants1 = br.readLine().toCharArray();
        for (int i = n1 - 1; i >= 0; i--) {
            list.add(new Ant(ants1[i], true));
        }

        char[] ants2 = br.readLine().toCharArray();
        for (int i = 0; i < n2; i ++) {
            list.add(new Ant(ants2[i], false));
        }

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (n1 + n2 - 1 <= t) {
            for (int i = 0; i < ants2.length; i++) {
                sb.append(ants2[i]);
            }
            for (int i = ants1.length - 1; i >= 0; i--) {
                sb.append(ants1[i]);
            }
            System.out.print(sb.toString());
            return;
        }

        while (t-- > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                Ant cur = list.get(i);
                Ant next = list.get(i + 1);

                if (!cur.team || cur.team == next.team) continue;

                list.set(i, next);
                list.set(i + 1, cur);
                i++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c);
        }
        System.out.print(sb.toString());

        br.close();
    }

    class Ant {
        char c;
        boolean team;

        Ant(char c, boolean team) {
            this.c = c;
            this.team = team;
        }
    }
}
