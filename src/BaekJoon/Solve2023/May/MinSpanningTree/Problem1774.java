package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem1774 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int godCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        uf = new int[godCnt + 1];

        for (int i = 1; i <= godCnt; i++) {
            uf[i] = i;
        }

        God[] godArr = new God[godCnt + 1];

        for (int i = 1; i <= godCnt; i++) {
            st = new StringTokenizer(br.readLine());
            godArr[i] = new God(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        List<Line> lineList = new ArrayList<>();
        for (int i = 1; i <= godCnt; i++) {
            for (int j = i + 1; j <= godCnt; j++) {
                lineList.add(new Line(i, j, godArr[i].getDistance(godArr[j])));
            }
        }
        Collections.sort(lineList);

        Double result = 0D;

        for (Line l : lineList) {
            if (find(l.from) != find(l.to)) {
                result += l.cost;
                union(l.from, l.to);
            }
        }

        bw.write(String.format("%.2f", result));

        br.close();
        bw.close();
    }

    private int find(int num) {
        while(uf[num] != num) {
            num = uf[num];
        }
        return num;
    }
    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            uf[b] = a;
        }
    }

    class God {
        long x;
        long y;

        public God(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }

        public double getDistance(God another) {
            return Math.sqrt(Math.pow(another.x - this.x, 2) + Math.pow(another.y - this.y, 2));
        }
    }

    class Line implements Comparable{
        int from;
        int to;
        double cost;

        public Line(int from_, int to_, double cost_) {
            this.from = from_;
            this.to = to_;
            this.cost = cost_;
        }

        @Override
        public int compareTo(Object o) {
            Line cpr = (Line) o;
            return Double.compare(this.cost, cpr.cost);
        }
    }
}
