package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem17472 {
    List<Vector> builableList = new ArrayList<>();
    List<Bridge> bridgeList = new ArrayList<>();
    final int INF = 101;
    int[][] field;
    int[] uf;
    int height;
    int width;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        field = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                int state = Integer.parseInt(st.nextToken());
                if (state == 1) {
                    field[i][j] = INF;
                }
            }
        }

        int idx = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j] == INF) {
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        for (Vector v : builableList) {
            chkBuildable(v);
        }
        Collections.sort(bridgeList);

        uf = new int[idx];
        for (int i = 1; i < idx; i++) {
            uf[i] = i;
        }

        int result = 0;
        for(Bridge b : bridgeList) {
            if (find(b.x) != find(b.y)) {
                result += b.cost;
                union(b.x, b.y);
            }
        }

        boolean flag = true;
        for (int i = 1; i < idx; i++) {
            for (int j = i + 1; j < idx; j++) {
                if (find(i) != find(j)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("-1");
        }

        br.close();
        bw.close();
    }

    private void bfs(int x, int y, int idx) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x, y));
        field[x][y] = idx;
        chkBuildable(x, y);

        while(!que.isEmpty()) {
            Point p = que.poll();

            if (p.y > 0 && field[p.x][p.y - 1] == INF) {
                field[p.x][p.y - 1] = idx;
                chkBuildable(p.x, p.y - 1);
                que.offer(new Point(p.x, p.y - 1));
            }

            if (p.x < height - 1 && field[p.x + 1][p.y] == INF) {
                field[p.x + 1][p.y] = idx;
                chkBuildable(p.x + 1, p.y);
                que.offer(new Point(p.x + 1, p.y));
            }

            if (p.y < width - 1 && field[p.x][p.y + 1] == INF) {
                field[p.x][p.y + 1] = idx;
                chkBuildable(p.x, p.y + 1);
                que.offer(new Point(p.x, p.y + 1));
            }

            if (p.x > 0 && field[p.x - 1][p.y] == INF) {
                field[p.x - 1][p.y] = idx;
                chkBuildable(p.x - 1, p.y);
                que.offer(new Point(p.x - 1, p.y));
            }
        }
    }
    private void chkBuildable(int x, int y) {
        if (y > 0 && field[x][y - 1] == 0) {
            builableList.add(new Vector(x, y, 4, field[x][y]));
        }

        if (x < height - 1 && field[x + 1][y] == 0) {
            builableList.add(new Vector(x, y, 3, field[x][y]));
        }

        if (y < width - 1 && field[x][y + 1] == 0) {
            builableList.add(new Vector(x, y, 2, field[x][y]));
        }

        if (x > 0 && field[x - 1][y] == 0) {
            builableList.add(new Vector(x, y, 1, field[x][y]));
        }
    }
    private void chkBuildable(Vector v) {
        if (v.direction == 1) {
            for (int i = 1; v.x - i >= 0; i++) {
                if (field[v.x - i][v.y] != 0) {
                    if (i < 3) {
                        break;
                    }
                    bridgeList.add(new Bridge(v.idx, field[v.x - i][v.y], i - 1));
                    break;
                }
            }
        } else if (v.direction == 2) {
            for (int i = 1; v.y + i < width; i++) {
                if (field[v.x][v.y + i] != 0) {
                    if (i < 3) {
                        break;
                    }
                    bridgeList.add(new Bridge(v.idx, field[v.x][v.y + i], i - 1));
                    break;
                }
            }
        } else if (v.direction == 3) {
            for (int i = 1; v.x + i < height; i++) {
                if (field[v.x + i][v.y] != 0) {
                    if (i < 3) {
                        break;
                    }
                    bridgeList.add(new Bridge(v.idx, field[v.x + i][v.y], i - 1));
                    break;
                }
            }
        } else if (v.direction == 4) {
            for (int i = 1; v.y - i >= 0; i++) {
                if (field[v.x][v.y - i] != 0) {
                    if (i < 3) {
                        break;
                    }
                    bridgeList.add(new Bridge(v.idx, field[v.x][v.y - i], i - 1));
                    break;
                }
            }
        }
    }
    private int find(int idx) {
        while(uf[idx] != idx) {
            idx = uf[idx];
        }
        return idx;
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            uf[root_b] = root_a;
        }
    }

    class Point {
        int x;
        int y;

        public Point() { }
        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }

    class Vector extends Point {
        int direction; // 1: 위, 2: 오른쪽, 3: 아래, 4: 왼쪽
        int idx;

        public Vector(int x_, int y_, int direction_, int idx_) {
            this.x = x_;
            this.y = y_;
            this.direction = direction_;
            this.idx = idx_;
        }
    }

    class Bridge extends Point implements Comparable {
        int cost;

        public Bridge(int x_, int y_, int cost_) {
            this.x = x_;
            this.y = y_;
            this.cost = cost_;
        }

        @Override
        public int compareTo(Object o) {
            Bridge cpr = (Bridge) o;
            return this.cost - cpr.cost;
        }
    }
}
