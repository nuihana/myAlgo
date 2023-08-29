package BaekJoon.Solve2023.August.HardSegmentQuery;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14287 {
    int ord, workerCnt;
    List<Integer>[] tree;
    int[] start, end, pwTree;
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

        pwTree = new int[workerCnt + 1];
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int idx = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());

                update(start[idx], amount);
            } else if (command.equals("2")) {
                int idx = Integer.parseInt(st.nextToken());

                bw.write(String.valueOf(query(end[idx]) - query(start[idx] - 1)));
                bw.newLine();
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
            pwTree[idx] += val;
            idx += idx & -idx;
        }
    }

    private int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += pwTree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}
