package BaekJoon.Solve2023.June.Conte_Chococup2;

import java.io.*;
import java.util.*;

public class Problem28256 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            int[][] chocoBox = new int[3][3];
            Point start = null;
            for (int i = 0; i < 3; i++) {
                String str = br.readLine();
                for (int j = 0; j < 3; j++) {
                    if (str.charAt(j) == 'O') {
                        chocoBox[i][j] = 1;
                        if (start == null) {
                            start = new Point(i, j);
                        }
                    } else if (str.charAt(j) == 'X') {
                        chocoBox[i][j] = 0;
                    } else {
                        chocoBox[i][j] = 2;
                    }
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int conditionCnt = Integer.parseInt(st.nextToken());
            int[] condition = new int[conditionCnt];
            for (int i = 0; i < conditionCnt; i++) {
                condition[i] = Integer.parseInt(st.nextToken());
            }

            if (start == null && conditionCnt == 0) { // 초콜릿 없음 + 없음 표시
                bw.write("1");
            } else if (start == null) { // 초콜릿 없음 + 있음 표시
                bw.write("0");
            } else { // 초콜릿 있음
                Queue<Point> que = new LinkedList<>();
                boolean[][] visited = new boolean[3][3];
                que.offer(start);
                visited[start.x][start.y] = true;

                int cnt = 0;
                List<Integer> setting = new ArrayList<>();
                while (!que.isEmpty()) {
                    Point now = que.poll();
                    cnt++;

                    if (now.x > 0 && !visited[now.x - 1][now.y] && chocoBox[now.x - 1][now.y] == 1) {
                        visited[now.x - 1][now.y] = true;
                        que.offer(new Point(now.x - 1, now.y));
                    }

                    if (now.y < 2 && !visited[now.x][now.y + 1] && chocoBox[now.x][now.y + 1] == 1) {
                        visited[now.x][now.y + 1] = true;
                        que.offer(new Point(now.x, now.y + 1));
                    }

                    if (now.x < 2 && !visited[now.x + 1][now.y] && chocoBox[now.x + 1][now.y] == 1) {
                        visited[now.x + 1][now.y] = true;
                        que.offer(new Point(now.x + 1, now.y));
                    }

                    if (now.y > 0 && !visited[now.x][now.y - 1] && chocoBox[now.x][now.y - 1] == 1) {
                        visited[now.x][now.y - 1] = true;
                        que.offer(new Point(now.x, now.y - 1));
                    }

                    if (que.isEmpty()) {
                        setting.add(cnt);
                        cnt = 0;
                        for (int i = 0; i < 3; i++) {
                            if (que.isEmpty()) {
                                for (int j = 0; j < 3; j++) {
                                    if (!visited[i][j] && chocoBox[i][j] == 1) {
                                        visited[i][j] = true;
                                        que.offer(new Point(i, j));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                Arrays.sort(condition);
                setting.sort((i1, i2) -> i1 - i2);

                String res = "1";
                if (condition.length == setting.size()) {
                    for (int i = 0; i < condition.length; i++) {
                        if (condition[i] != setting.get(i)) {
                            res = "0";
                            break;
                        }
                    }
                } else {
                    res = "0";
                }

                bw.write(res);
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;
        public Point(int x_, int y_) {
            x = x_;
            y = y_;
        }
    }
}
