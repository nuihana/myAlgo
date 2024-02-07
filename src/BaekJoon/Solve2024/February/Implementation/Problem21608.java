package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem21608 {
    int n;
    int[][] map;
    int[] student, dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    Set<Integer>[] set;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        set = new Set[n * n + 1];
        student = new int[n * n + 1];

        for (int i = 1; i <= n * n; i++) {
            set[i] = new HashSet<>();
        }

        for (int i = 1; i <= n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            student[i] = idx;

            for (int j = 0; j < 4; j++) {
                int similar = Integer.parseInt(st.nextToken());
                set[idx].add(similar);
            }
        }

        map[1][1] = student[1];

        simulate();
        System.out.print(getAnswer());

        br.close();
    }

    private void simulate() {
        for (int i = 2; i <= n * n; i++) {
            setPos(i);
        }
    }

    private void setPos(int idx) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) continue;
                pq.add(getStudent(i, j, idx));
            }
        }

        int x = pq.peek().x;
        int y = pq.peek().y;
        map[x][y] = student[idx];
    }

    private Student getStudent(int x, int y, int s) {
        int cnt = 0;
        int emptyCnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (set[student[s]].contains(map[nx][ny])) cnt++;
            if (map[nx][ny] == 0) emptyCnt++;
        }

        return new Student(x, y, cnt, emptyCnt);
    }

    private int getAnswer() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (set[map[i][j]].contains(map[nx][ny])) cnt++;
                }
                if (cnt == 1) sum += 1;
                else if (cnt == 2) sum += 10;
                else if (cnt == 3) sum += 100;
                else if (cnt == 4) sum += 1000;
            }
        }

        return sum;
    }

    class Student implements Comparable<Student> {
        int x, y, cnt, emptyCnt;

        public Student(int x, int y, int cnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Student o) {
            if (o.cnt == this.cnt) {
                if (o.emptyCnt == this.emptyCnt) {
                    if (o.x == this.x) {
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return o.emptyCnt - this.emptyCnt;
            }
            return o.cnt - this.cnt;
        }
    }
}
