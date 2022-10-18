package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17387 {
	public void solution() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Line line1 = new Line(bf.readLine());
		Line line2 = new Line(bf.readLine());
		
		bf.close();
		
		if (line1.isCrossed(line2)) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}
	
	class Line {
		private int x1;
		private int y1;
		private int x2;
		private int y2;
		
		private int inclination;
		private int constant;
		
		public Line() {
			
		}
		
		public Line(String info) {
			String[] points = info.split(" ");
			
			x1 = Integer.parseInt(points[0]);
			y1 = Integer.parseInt(points[1]);
			x2 = Integer.parseInt(points[2]);
			y2 = Integer.parseInt(points[3]);
			
			inclination = (y2 - y1) / (x2 - x1);
			constant = y1 - inclination * x1;
		}
		
		public String getEquation() {
			return inclination + "+" + constant;
		}
		
		public boolean isIncludedX(double val) {
			if (x1 > x2) {
				if (val >= x2 && x1 >= val) {
					return true;
				} else {
					return false;
				}
			} else if (x1 == x2) {
				if (val == (int) val) {
					if ((int) val == x1) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				if (val >= x1 && x2 >= val) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		public boolean isIncludedX(int val) {
			if (x1 > x2) {
				if (val >= x2 && x1 >= val) {
					return true;
				} else {
					return false;
				}
			} else if (x1 == x2) {
				if (val == x1) {
					return true;
				} else {
					return false;
				}
			} else {
				if (val >= x1 && x2 >= val) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		public boolean isCrossed(Line another) {
			String[] anotherEquation = another.getEquation().split("[+]");
			int anotherInclination = Integer.parseInt(anotherEquation[0]);
			int anotherConstnat = Integer.parseInt(anotherEquation[1]);
			
			if (inclination == anotherInclination) {
				if (constant == anotherConstnat && (another.isIncludedX(x1) || another.isIncludedX(x2))) {
					return true;
				} else {
					return false;
				}
			} else {
				double crossX = (anotherConstnat - constant) / (inclination - anotherInclination);
				
				if (isIncludedX(crossX) && another.isIncludedX(crossX)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
