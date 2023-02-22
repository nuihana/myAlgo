package BaekJoon.Solve2022.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem18870 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int inputCnt = Integer.parseInt(br.readLine());
		List<Coordinate> valList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			valList.add(new Coordinate(st.nextToken(), i));
		}
		
		valList.sort((a, b) -> a.getX() - b.getX());
		
		for (int i = 0, adder = -1, tmp = Integer.MIN_VALUE; i < valList.size(); i++) {
			if (tmp != valList.get(i).getX()) {
				adder++;
			}
			
			valList.get(i).setAfterX(adder);
			
			tmp = valList.get(i).getX();
		}
		
		valList.sort((a, b) -> a.getOrder() - b.getOrder());
		
		for (int i = 0; i < valList.size(); i++) {
			bw.write(valList.get(i).getAfterX() + " ");
		}
		
		br.close();
		bw.close();
	}
	
	class Coordinate {
		private int x;
		private int afterX;
		private int order;
		
		public Coordinate(String xStr, int order_) {
			this.x = Integer.parseInt(xStr);
			this.order = order_;
		}
		public int getX() {
			return x;
		}
		public int getOrder() {
			return order;
		}
		public int getAfterX() {
			return afterX;
		}
		public void setAfterX(int afterX) {
			this.afterX = afterX;
		}
	}
}
