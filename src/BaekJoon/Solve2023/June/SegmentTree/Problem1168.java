package BaekJoon.Solve2023.June.SegmentTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1168 {
    int[] tree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int term = Integer.parseInt(st.nextToken());

        tree = new int[num * 4];
        init(0, num - 1, 1);
        List<Integer> seq = new ArrayList<>();
        int rank = term;
        while(tree[1] > 0) {
            seq.add(print(0, num - 1, 1, rank));
            rank += term - 1;
            if (tree[1] > 0 && rank > tree[1]) {
                if (rank % tree[1] == 0) {
                    rank = tree[1];
                } else {
                    rank %= tree[1];
                }
            }
        }

        bw.write("<");
        for (int i = 0; i < seq.size(); i++) {
            bw.write(String.valueOf(seq.get(i)));
            if (i < seq.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        br.close();
        bw.close();
    }

    private int init(int start, int end, int node) {
        if (start == end) return tree[node] = 1;
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    private int print(int start, int end, int node, int rank) {
        if (start == end) {
            tree[node]--;
            return start + 1;
        }
        int mid = (start + end) / 2;
        int ret = 0;
        if (rank <= tree[node * 2]) {
            ret = print(start, mid, node * 2, rank);
        } else {
            ret = print(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return ret;
    }
}
