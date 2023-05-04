package BaekJoon.Solve2023.May.MinSpanningTree;

import java.io.*;
import java.util.*;

public class Problem4386 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int starCnt = Integer.parseInt(br.readLine());
        List<Point> pList = new ArrayList<>();
        Map<Integer, List<Line>> lineMap = new HashMap<>();
        for (int i = 1; i <= starCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            Point thisP = new Point(x, y, i);

            for (Point p : pList) {
                if (lineMap.get(p.idx) == null) {
                    List<Line> tmpList = new ArrayList<>();

                    tmpList.add(new Line(i, p.getDistance(thisP)));

                    lineMap.put(p.idx, tmpList);
                } else {
                    lineMap.get(p.idx).add(new Line(i, p.getDistance(thisP)));
                }

                if (lineMap.get(i) == null) {
                    List<Line> tmpList = new ArrayList<>();

                    tmpList.add(new Line(p.idx, thisP.getDistance(p)));

                    lineMap.put(i, tmpList);
                } else {
                    lineMap.get(i).add(new Line(p.idx, thisP.getDistance(p)));
                }
            }

            pList.add(thisP);
        }

        boolean[] included = new boolean[starCnt + 1];
        PriorityQueue<Line> que = new PriorityQueue<>((l1, l2) -> Float.compare(l1.cost, l2.cost));

        que.offer(new Line(1, 0F));

        float result = 0F;
        while(!que.isEmpty()) {
            Line tmp = que.poll();

            if (included[tmp.idx]) continue;
            included[tmp.idx] = true;
            result += tmp.cost;

            for (Line l : lineMap.get(tmp.idx)) {
                if (!included[l.idx]) {
                    que.offer(l);
                }
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    class Point {
        float x;
        float y;
        int idx;

        public Point(float x_, float y_, int idx_) {
            this.x = x_;
            this.y = y_;
            this.idx = idx_;
        }

        public float getDistance(Point another) {
            float sum = 0F;
            sum += Math.pow(another.x - this.x, 2);
            sum += Math.pow(another.y - this.y, 2);
            return (float) Math.sqrt(sum);
        }
    }

    class Line {
        int idx;
        float cost;

        public Line(int idx_, float cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }
    }
}
