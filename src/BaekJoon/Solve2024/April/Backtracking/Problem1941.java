package BaekJoon.Solve2024.April.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1941 {
    int res;
    char[][] field;
    int[] combX = new int[25], combY = new int[25];
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                field[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < 25; i++) {
            combX[i] = i % 5;
            combY[i] = i / 5;
        }

        res = 0;
        search(new int[7], 0, 0, 7);
        System.out.print(res);

        br.close();
    }

    private void search(int[] arr, int idx, int depth, int left) {
        if (left == 0) {
            bfs(arr);
            return;
        }

        if (depth == 25) return;

        arr[idx] = depth;
        search(arr, idx + 1, depth + 1, left - 1);
        search(arr, idx, depth + 1, left);
    }

    private void bfs(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[7];

        isVisited[0] = true;
        q.add(arr[0]);
        int cnt = 1, sCnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (field[combX[now]][combY[now]] == 'S') sCnt++;

            for (int i = 0; i < 4; i++) {
                for (int next = 1; next < 7; next++) {
                    if (!isVisited[next] && combX[now] + dx[i] == combX[arr[next]] && combY[now] + dy[i] == combY[arr[next]]) {
                        isVisited[next] = true;
                        q.add(arr[next]);
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7 && sCnt >= 4) res++;
    }
}
