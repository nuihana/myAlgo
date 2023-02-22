package BaekJoon.Solve2022;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17387 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Point lineAEnd = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point lineABegin = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Line lineA = new Line(lineABegin, lineAEnd);

		st = new StringTokenizer(br.readLine());
		Point lineBEnd = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Point lineBBegin = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		Line lineB = new Line(lineBBegin, lineBEnd);

		if (lineA.isCrossed2(lineB)) {
			bw.write("1");
		} else {
			bw.write("0");
		}

		br.close();
		bw.close();
	}

	class Point implements Comparable<Point> {
		long x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) {
				return this.y - o.y > 0 ? 1 : this.y - o.y < 0 ? -1 : 0;
			}
			return this.x - o.x > 0 ? 1 : this.x - o.x < 0 ? -1 : 0;
		}
	}

	class Line {
		Point p1, p2;

		public Line(Point p1, Point p2) {
			this.p1 = p1.compareTo(p2) <= 0 ? p1 : p2;
			this.p2 = p1.compareTo(p2) <= 0 ? p2 : p1;
		}

		private int ccw (Point a, Point b, Point c) {
			long sum = 0;
			Point[] arr = {a, b, c, a};

			for (int i = 0; i < 3; i++) {
				sum += arr[i].x * arr[i + 1].y - arr[i + 1].x * arr[i].y;
			}

			return sum > 0 ? 1 : sum < 0 ? -1 : 0;
		}

		public boolean isCrossed2(Line line2) {
			int res1 = ccw(p1, p2, line2.p1) * ccw(p1, p2, line2.p2);
			int res2 = ccw(line2.p1, line2.p2, p1) * ccw(line2.p1, line2.p2, p2);

			if (res1 == 0 && res2 == 0) {
				return p1.compareTo(line2.p2) <= 0 && line2.p1.compareTo(p2) <= 0;
			}

			return res1 <= 0 && res2 <= 0;
		}
	}
}
