package BaekJoon.Solve2023.August.HardSegmentQuery;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14268 {
    int ord, workerCnt;
    List<Integer>[] tree;
    int[] mapping, rangeEnd, pwTree;
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

        ord = 1;
        mapping = new int[workerCnt + 1];
        rangeEnd = new int[workerCnt + 1];
        eulerTour(1);

        pwTree = new int[workerCnt + 1];
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("1")) {
                int idx = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());

                rangeUpdate(idx, amount);
            } else if (command.equals("2")) {
                int idx = Integer.parseInt(st.nextToken());

                bw.write(String.valueOf(query(idx)));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    private int eulerTour(int node) {
        int end = mapping[node] = ord++;
        if (tree[node] == null) return rangeEnd[end] = end;

        for (int next : tree[node]) {
            end = eulerTour(next);
        }

        rangeEnd[mapping[node]] = end;
        return end;
    }

    private void update(int idx, int val) {
        while (idx <= workerCnt) {
            pwTree[idx] += val;
            idx += idx & -idx;
        }
    }

    private void rangeUpdate(int start, int end, int val) {
        update(start, val);
        update(end + 1, -val);
    }

    private void rangeUpdate(int idx, int val) {
        int s = mapping[idx];
        int e = rangeEnd[s];
        if (e == 0) return;
        rangeUpdate(s, e, val);
    }

    private int query(int idx) {
        idx = mapping[idx];
        int sum = 0;
        while (idx > 0) {
            sum += pwTree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
}
