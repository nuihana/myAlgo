package BaekJoon.Solve2023.August.HardSegmentQuery;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14288 {
    int ord, workerCnt;
    List<Integer>[] tree;
    int[] start, end, upTree, downTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        workerCnt = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        tree = new ArrayList[workerCnt + 1];
        st = new StringTokenizer(br.readLine());
        st.nextToken(); // 사장 열외
        for (int i = 2; i <= workerCnt; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (tree[cur] == null) tree[cur] = new ArrayList<>();
            tree[cur].add(i);
        }

        ord = 0;
        start = new int[workerCnt + 1];
        end = new int[workerCnt + 1];
        eulerTour(1);

        upTree = new int[workerCnt + 1];
        downTree = new int[workerCnt + 1];
        boolean direction = true;
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int idx = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());

                if (direction) {
                    downUpdate(start[idx], end[idx], amount);
                } else {
                    upUpdate(start[idx], amount);
                }
            } else if (command.equals("2")) {
                int idx = Integer.parseInt(st.nextToken());

                bw.write(String.valueOf(query(idx)));
                bw.newLine();
            } else if (command.equals("3")) {
                direction = !direction;
            }
        }

        br.close();
        bw.close();
    }

    private void eulerTour(int node) {
        start[node] = ++ord;
        if (tree[node] == null) {
            end[node] = ord;
            return;
        }

        for (int next : tree[node]) {
            eulerTour(next);
        }

        end[node] = ord;
    }

    private void update(int idx, int val) {
        while (idx <= workerCnt) {
            downTree[idx] += val;
            idx += idx & -idx;
        }
    }

    private void downUpdate(int start, int end, int val) {
        update(start, val);
        update(end + 1, -val);
    }

    private void upUpdate(int idx, int val) {
        while (idx <= workerCnt) {
            upTree[idx] += val;
            idx += idx & -idx;
        }
    }

    private int query(int idx) {
        return downQuery(start[idx]) + (upQuery(end[idx]) - upQuery(start[idx] - 1));
    }

    private int downQuery(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += downTree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    private int upQuery(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += upTree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}
