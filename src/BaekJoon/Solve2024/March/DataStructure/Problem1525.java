package BaekJoon.Solve2024.March.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1525 {
    final String correct = "123456780";
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    Map<String, Integer> map = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder init = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int val = Integer.parseInt(st.nextToken());
                init.append(val);
            }
        }

        map.put(init.toString(), 0);
        System.out.print(bfs(init.toString()));

        br.close();
    }

    private int bfs(String init) {
        Queue<String> q = new LinkedList<>();
        q.offer(init);
        while (!q.isEmpty()) {
            String now = q.poll();
            int move = map.get(now);
            int empty = now.indexOf('0');
            int x = empty % 3;
            int y = empty / 3;

            if (now.equals(correct)) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;

                int nPos = ny * 3 + nx;
                char ch = now.charAt(nPos);
                String next = now.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    q.offer(next);
                    map.put(next, move + 1);
                }
            }
        }
        return -1;
    }
}
