package BaekJoon.Solve2024.April.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem5635 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        while (cnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            list.add(new Node(name, day, month, year));
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y != o2.y) return o1.y - o2.y;
                if (o1.m != o2.m) return o1.m - o2.m;
                return o1.d - o2.d;
            }
        });

        System.out.println(list.get(0).name);
        System.out.print(list.get(list.size() - 1).name);

        br.close();
    }

    class Node {
        int d, m, y;
        String name;

        public Node(String n_, int d_, int m_, int y_) {
            name = n_;
            d = d_;
            m = m_;
            y = y_;
        }
    }
}
